    package com.mycompany.project.client;

import com.google.gwt.uibinder.elementparsers.ListBoxParser;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;

import com.google.gwt.maps.client.InfoWindow;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.event.MapClickHandler;
import com.google.gwt.maps.client.event.MapTypeChangedHandler;
import com.google.gwt.maps.client.event.MarkerClickHandler;
import com.google.gwt.maps.client.event.PolylineClickHandler;
import com.google.gwt.maps.client.event.MapTypeChangedHandler.MapTypeChangedEvent;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.geom.Point;
import com.google.gwt.maps.client.overlay.Icon;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.MarkerOptions;
import com.google.gwt.maps.client.overlay.Polyline;
import com.google.gwt.maps.client.overlay.PolylineOptions;

/**
 * Klasse zum Verwalten der Kanten-, Knoten- und Raumdaten.
 * @author Martin Zellner
 * @author David Schmid
 * 
 * 
 */

public class Eingeben extends PopupPanel{

	static CheckBox chckbxMitName = new CheckBox("Mit Name");
	static CheckBox chckbxMitAbteilung = new CheckBox("Mit Abteilung");
	static RadioButton radiobtnBearbeiten = new RadioButton("weg", "Bearbeiten");
	static RadioButton radiobtnEintragen = new RadioButton("weg", "Eintragen");
	static RadioButton radiobtnLoeschen = new RadioButton("weg", "Loeschen");
	static RadioButton radiobtnTreppe = new RadioButton("weg", "Treppe eintragen");
	static Button btnBack = new Button("Zurueck");
	static ListBox listboxVon = new ListBox();
	static ListBox listboxBis = new ListBox();
	static AbsolutePanel absolutePanel = new AbsolutePanel();
	static boolean insert=true;
	static boolean lasttreppe= false;
	static Grid grid = new Grid(2, 4);
	static private MapWidget map;
	static LatLng oldlatln;
	static Marker oldmarker;
	static PolylineOptions po = PolylineOptions.newInstance();
	static MarkerOptions mox = MarkerOptions.newInstance();
	static MarkerOptions mot = MarkerOptions.newInstance();
	static ClickHandler radiobtnch = new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			delX();
		}
	};
	static MarkerClickHandler mchx = new MarkerClickHandler() {
		
		@Override
		public void onClick(MarkerClickEvent event) {
			map.removeOverlay(event.getSender());
			Marker tmp = new Marker(event.getSender().getLatLng());
			tmp.addMarkerClickHandler(mch);
			map.addOverlay(tmp);
			oldmarker = null;
			oldlatln = null;
		}
	};
	static MarkerClickHandler mch = new MarkerClickHandler() {
		
		@Override
		public void onClick(MarkerClickEvent event) {
			if (radiobtnLoeschen.getValue()){
				LatLng del = event.getSender().getLatLng();
				update.Util.getInstance().knoten_loeschen(del.getLatitude(), del.getLongitude(), currentNiveau(),new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
				refreshMap(currentNiveau(), del);
			} else if (radiobtnBearbeiten.getValue()) {
				map.getInfoWindow().open(event.getSender(), new InfoWindowContent(new KnotenInfo(event.getSender().getLatLng(),currentNiveau())));
				//map.getInfoWindow().open(event.getSender(), new InfoWindowContent(new TestInfoWinContent()));
			} else if (radiobtnEintragen.getValue() && oldlatln == null){
				oldlatln = event.getSender().getLatLng();
				map.removeOverlay(event.getSender());
				Icon iconX = Icon.newInstance("markerX.png");
				iconX.setIconAnchor(Point.newInstance(9, 34));
				mox.setIcon(iconX);
				Marker tmp = new Marker(oldlatln, mox);
				tmp.addMarkerClickHandler(mchx);
				map.addOverlay(tmp);
				oldmarker = tmp;
				
			} else if (radiobtnEintragen.getValue() && oldlatln != null){
				//zeichne neuen weg
				LatLng[] wegpunkte = {oldlatln,event.getSender().getLatLng()};
				Polyline neuerweg = new Polyline(wegpunkte,"darkblue",7);
				neuerweg.addPolylineClickHandler(pch);
				update.Util.getInstance().kante_einfuegen(wegpunkte[0].getLatitude(), wegpunkte[0].getLongitude(),wegpunkte[1].getLatitude(), wegpunkte[1].getLongitude(), 1, currentNiveau(), new AsyncCallback<Void>() {
					@Override
					public void onSuccess(Void result) {
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
				//kante einzeichnen
				map.addOverlay(neuerweg);
				//alten markierten marker zuruecksetzen
				map.removeOverlay(oldmarker);
				if(lasttreppe){
					Icon iconT = Icon.newInstance("markerT.png");
					iconT.setIconAnchor(Point.newInstance(9, 34));
					mot.setIcon(iconT);
					Marker tmp = new Marker(oldlatln,mot);
					tmp.addMarkerClickHandler(mcht);
					map.addOverlay(tmp);
					
				} else{
					Marker tmp = new Marker(oldlatln);
					tmp.addMarkerClickHandler(mch);
					map.addOverlay(tmp);
				}
				lasttreppe=false;

				//neuen marker markieren
				map.removeOverlay(event.getSender());
				oldmarker = new Marker(event.getSender().getLatLng(), mox);
				oldmarker.addMarkerClickHandler(mchx);
				map.addOverlay(oldmarker);
				oldlatln = event.getSender().getLatLng();
			}
		}
	};
	static MarkerClickHandler mchxt = new MarkerClickHandler() {
		
		@Override
		public void onClick(MarkerClickEvent event) {
			map.removeOverlay(event.getSender());
			Icon iconT = Icon.newInstance("markerT.png");
			iconT.setIconAnchor(Point.newInstance(9, 34));
			mot.setIcon(iconT);
			Marker tmp = new Marker(event.getSender().getLatLng(), mot);
			
			tmp.addMarkerClickHandler(mcht);
			map.addOverlay(tmp);
			oldmarker = null;
			oldlatln = null;
		}
	};
	static MarkerClickHandler mcht = new MarkerClickHandler() {
		
		@Override
		public void onClick(MarkerClickEvent event) {
			if (radiobtnLoeschen.getValue()){
				LatLng del = event.getSender().getLatLng();
				update.Util.getInstance().knoten_loeschen_all(del.getLatitude(), del.getLongitude(), new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
				refreshMap(currentNiveau(), del);

			} else if (radiobtnBearbeiten.getValue()) {
//				DO NOTHING
			} else if (radiobtnEintragen.getValue() && oldlatln == null){
				lasttreppe=true;
				oldlatln = event.getSender().getLatLng();
				map.removeOverlay(event.getSender());
				Icon iconX = Icon.newInstance("markerX.png");
				iconX.setIconAnchor(Point.newInstance(9, 34));
				mox.setIcon(iconX);
				Marker tmp = new Marker(oldlatln, mox);
				tmp.addMarkerClickHandler(mchxt);
				map.addOverlay(tmp);
				oldmarker = tmp;
				
			} else if (radiobtnEintragen.getValue() && oldlatln != null){
				//zeichne neuen weg
				LatLng[] wegpunkte = {oldlatln,event.getSender().getLatLng()};
				Polyline neuerweg = new Polyline(wegpunkte,"darkblue",7);
				neuerweg.addPolylineClickHandler(pch);
				update.Util.getInstance().kante_einfuegen(wegpunkte[0].getLatitude(), wegpunkte[0].getLongitude(),wegpunkte[1].getLatitude(), wegpunkte[1].getLongitude(), 1, currentNiveau(), new AsyncCallback<Void>() {
					@Override
					public void onSuccess(Void result) {
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
				//kante einzeichnen
				map.addOverlay(neuerweg);
				//alten markierten marker zuruecksetzen
				map.removeOverlay(oldmarker);
				if(lasttreppe){
					Icon iconT = Icon.newInstance("markerT.png");
					iconT.setIconAnchor(Point.newInstance(9, 34));
					mot.setIcon(iconT);
					Marker tmp = new Marker(oldlatln,mot);
					tmp.addMarkerClickHandler(mcht);
					map.addOverlay(tmp);
					
				} else{
					Marker tmp = new Marker(oldlatln);
					tmp.addMarkerClickHandler(mch);
					map.addOverlay(tmp);
				}
				lasttreppe=true;
				//neuen marker markieren
				map.removeOverlay(event.getSender());
				oldmarker = new Marker(event.getSender().getLatLng(), mox);
				oldmarker.addMarkerClickHandler(mchxt);
				map.addOverlay(oldmarker);
				oldlatln = event.getSender().getLatLng();
			
			}
		}
	};
	static PolylineClickHandler pch = new PolylineClickHandler() {
		@Override
		public void onClick(PolylineClickEvent event) {
			if(radiobtnLoeschen.getValue()){
				LatLng del1 = event.getSender().getVertex(0);
				LatLng del2 = event.getSender().getVertex(1);
				update.Util.getInstance().kante_loeschen(del1.getLatitude(), del1.getLongitude(),del2.getLatitude(), del2.getLongitude(), currentNiveau(), new AsyncCallback<Void>() {
					@Override
					public void onSuccess(Void result) {
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
				map.removeOverlay(event.getSender());
			}
		}
	};
	
	public Eingeben() {
		super();
		setSize("850px", "800px");
		setWidget(absolutePanel);
		absolutePanel.setSize("620px", "600px");

		KarteFlx karte = new KarteFlx();
	    map = karte.map;
	    initMap(2);
		btnBack.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});	
			    
	    map.addMapClickHandler(new MapClickHandler() {
			@Override
			public void onClick(MapClickEvent event) {
				if (radiobtnEintragen.getValue()) {
					Marker marker = new Marker(event.getLatLng());
					update.Util.getInstance().knoten_einfuegen(marker.getLatLng().getLatitude(), marker.getLatLng().getLongitude(), 1, currentNiveau(), new AsyncCallback<Void>() {
						
						@Override
						public void onSuccess(Void result) {
						}
						
						@Override
						public void onFailure(Throwable caught) {	
						}
					});
					marker.addMarkerClickHandler(mch);
					map.addOverlay(marker);					
				} else if (radiobtnTreppe.getValue()){
					
					for (int i=listboxVon.getSelectedIndex()+1;i<=listboxBis.getSelectedIndex()+1;i++){
						update.Util.getInstance().knoten_einfuegen(event.getLatLng().getLatitude(), event.getLatLng().getLongitude(), 2, i, new AsyncCallback<Void>() {
							
							@Override
							public void onSuccess(Void result) {
							}
							
							@Override
							public void onFailure(Throwable caught) {	
							}
						});
					}
					if(currentNiveau()<=listboxBis.getSelectedIndex()+1 &&currentNiveau()>= listboxVon.getSelectedIndex()+1){
						Icon iconT = Icon.newInstance("markerT.png");
						iconT.setIconAnchor(Point.newInstance(9, 34));
						mot.setIcon(iconT);
						Marker marker = new Marker(event.getLatLng(), mot);
						marker.addMarkerClickHandler(mcht);
						map.addOverlay(marker);
					}
					
					
				}
			}
		});
	    map.addMapTypeChangedHandler(new MapTypeChangedHandler() {
			
			@Override
			public void onTypeChanged(MapTypeChangedEvent event) {
				delX();
				initMap(currentNiveau());
			}
		});

	    absolutePanel.add(map, 10, 70);
		
		
		absolutePanel.add(grid, 0, 0);
		grid.setSize("495px", "50px");
		
		radiobtnLoeschen.addClickHandler(radiobtnch);
		radiobtnBearbeiten.addClickHandler(radiobtnch);
		radiobtnTreppe.addClickHandler(radiobtnch);
		listboxVon.addItem("Niv1");
		listboxVon.addItem("Niv2");
		listboxVon.addItem("Niv3");
		listboxVon.addItem("Niv4");
		listboxVon.addItem("Niv5");
		listboxBis.addItem("Niv1");
		listboxBis.addItem("Niv2");
		listboxBis.addItem("Niv3");
		listboxBis.addItem("Niv4");
		listboxBis.addItem("Niv5");
		listboxVon.setVisibleItemCount(1);
		listboxBis.setVisibleItemCount(1);
		
		grid.setWidget(0, 0, radiobtnEintragen);
		grid.setWidget(0, 1, radiobtnLoeschen);
		grid.setWidget(0, 2, radiobtnBearbeiten);
		grid.setWidget(0, 3, btnBack);
		grid.setWidget(1, 0, radiobtnTreppe);
		grid.setWidget(1, 1, listboxVon);
		grid.setWidget(1, 2, listboxBis);
	}
	private static void initMap (int niv){
		map.clearOverlays();
		initKnoten(niv);
		initKanten(niv);
	}
	private static void initKnoten (int niv){
		update.Util.getInstance().knoten_auslesen(niv, new AsyncCallback<Knoten[]>() {
			
			@Override
			public void onSuccess(Knoten[] result) {
				for (int i=0;i<result.length;i++){
					if (result[i].typ==1){
						Marker marker = new Marker(LatLng.newInstance(result[i].lat, result[i].lng));
						marker.addMarkerClickHandler(mch);
						map.addOverlay(marker);
					} else if(result[i].typ==2){
						Icon iconT = Icon.newInstance("markerT.png");
						iconT.setIconAnchor(Point.newInstance(9, 34));
						mot.setIcon(iconT);
						Marker marker = new Marker(LatLng.newInstance(result[i].lat, result[i].lng),mot);
						marker.addMarkerClickHandler(mcht);
						map.addOverlay(marker);
					}
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	private static void initKnoten (int niv, LatLng del){
		update.Util.getInstance().knoten_auslesennot(niv,del.getLatitude(), del.getLongitude(), new AsyncCallback<Knoten[]>() {
			
			@Override
			public void onSuccess(Knoten[] result) {
				for (int i=0;i<result.length;i++){
					if (result[i].typ==1){
						Marker marker = new Marker(LatLng.newInstance(result[i].lat, result[i].lng));
						marker.addMarkerClickHandler(mch);
						map.addOverlay(marker);
					} else if(result[i].typ==2){
						Icon iconT = Icon.newInstance("markerT.png");
						iconT.setIconAnchor(Point.newInstance(9, 34));
						mot.setIcon(iconT);
						Marker marker = new Marker(LatLng.newInstance(result[i].lat, result[i].lng),mot);
						marker.addMarkerClickHandler(mcht);
						map.addOverlay(marker);
					}
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	private static void initKanten (int niv){
		update.Util.getInstance().kanten_auslesen(niv, new AsyncCallback<Kante[]>() {
			
			@Override
			public void onSuccess(Kante[] result) {
				for (int i=0;i<result.length;i++){
					LatLng[] lolz = {LatLng.newInstance(result[i].lat1,result[i].lng1),LatLng.newInstance(result[i].lat2,result[i].lng2)};
					Polyline poly = new Polyline(lolz,"darkblue",7);
					poly.addPolylineClickHandler(pch);
					map.addOverlay(poly);
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	private static void refreshMap (int niv, LatLng del){
		map.clearOverlays();
		initKnoten(niv, del);
		initKanten(niv, del);
		
	}
	private static void initKanten (int niv, LatLng del){
		
		update.Util.getInstance().kanten_auslesennot(niv,del.getLatitude(),del.getLongitude(),new AsyncCallback<Kante[]>() {
			

			@Override
			public void onSuccess(Kante[] result) {
				for (int i=0;i<result.length;i++){
					LatLng[] lolz = {LatLng.newInstance(result[i].lat1,result[i].lng1),LatLng.newInstance(result[i].lat2,result[i].lng2)};
					Polyline poly = new Polyline(lolz,"darkblue",7);
					poly.addPolylineClickHandler(pch);
					map.addOverlay(poly);
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	@Override
	protected void onDetach() {
		super.onDetach();
		Window.Location.reload();
	}
	private static int currentNiveau(){
		return Integer.parseInt(map.getCurrentMapType().getName(false).split(" ")[1]);
//		String[] x = niv.split(" ");
//		int i = Integer.parseInt(x[1]);
//		System.out.println("DEBUG: niveau = "+i);
		
//		return i;
	}
	private static void delX(){
		if (null != oldlatln){
			lasttreppe=false;
			map.removeOverlay(oldmarker);
			oldmarker=null;
			Marker tmp = new Marker(oldlatln);
			tmp.addMarkerClickHandler(mch);
			map.addOverlay(tmp);
			oldlatln=null;
		}
		
	}
}
