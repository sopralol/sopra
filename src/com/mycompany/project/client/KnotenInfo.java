package com.mycompany.project.client;


import org.apache.commons.digester.rss.Item;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Zustaendig zum Anzeigen und editieren von Raum- und Personendaten die den Knoten betreffen.
 * @author Martin Zellner
 * @author David Schmid
 * 
 * 
 */
public class KnotenInfo extends Composite {
	private static VerticalPanel panel;
	private static boolean first=true;
	private static Grid grid;
	private static Grid gridPersonen;
	private static Raum raum;
	private static Button btnSpeichern = new Button("Speichern");
	private static Button btnSuchen = new Button("S");
	private static Button btnPlus = new Button("+");
	private static Button btnClear = new Button("C");
	private static Label lblName = new Label("Name/Nr.:");;
	private static Label lblTyp = new Label("Raumtyp:");
	private static TextBox txtName = new TextBox();
	private static TextBox txtVorname = new TextBox();
	private static TextBox txtNachname= new TextBox();
	private static TextBox txtTitel = new TextBox();
	private static ListBox lbTyp = new ListBox();
	private static ListBox lbResult;
	private static ClickHandler chm = new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			Button tmp = (Button) event.getSource();
			String[] split = tmp.getTitle().split(" ");
			int pid = Integer.parseInt(split[0]);
			int gridrow = Integer.parseInt(split[1]);
			update.Util.getInstance().person_von_raum(pid, new AsyncCallback<Void>() {
				@Override
				public void onSuccess(Void result) {
				}
				@Override
				public void onFailure(Throwable caught) {
				}
			});
			gridPersonen.removeRow(gridrow);
			fixBug(gridrow);
		}

	};
	/**
	 * Veraendert die gespeichetren Informationen die beim Loeschen der Zeile ausschlaggebend sind
	 * @param pGridrow gibt die Stelle der zu loeschenden Reihe an.
	 * 
	 */
	private static void fixBug(int pGridrow) {
		// methode schreibt values der buttons um
		for (int i = pGridrow; i <= gridPersonen.getRowCount(); i++) {
			Button tmp = (Button) gridPersonen.getWidget(i, 0);
			String[] split = tmp.getTitle().split(" ");
			int pid = Integer.parseInt(split[0]);
			int gridrow = Integer.parseInt(split[1]);
			gridrow--;
			tmp.setTitle(pid + " " + gridrow);
		}
		
	}
	
	private static ClickHandler chsp = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			if(null != raum.name){
				update.Util.getInstance().raum_aendern(lbTyp.getSelectedIndex(), txtName.getText(), raum.id, new AsyncCallback<Void>() {
					@Override
					public void onSuccess(Void result) {
					}
					@Override
					public void onFailure(Throwable caught) {
					}
				});
			} else {
				update.Util.getInstance().raum_einfuegen(lbTyp.getSelectedIndex(), txtName.getText(), raum.kid, new AsyncCallback<Integer>() {
					@Override
					public void onSuccess(Integer result) {
						raum.id=result;
						raum.name=txtName.getText();
						raum.typ=lbTyp.getSelectedIndex();
					}
					@Override
					public void onFailure(Throwable caught) {
						raum.id=-1;
					}
				});
				
			}
		}
	};
	private static ClickHandler chs = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			update.Util.getInstance().person_suchen(txtVorname.getText(), txtNachname.getText(), "", txtTitel.getText(), new AsyncCallback<Person[]>() {
				@Override
				public void onSuccess(Person[] result) {
					lbResult = new ListBox();
					for (int i = 0; i < result.length; i++) {
						lbResult.addItem(result[i].toString());
					}
					lbResult.setVisibleItemCount(1);
					
					gridPersonen.setWidget(0, 0, btnPlus);
					gridPersonen.setWidget(0, 1, lbResult);
					
					gridPersonen.setWidget(0, 2, btnClear);
					gridPersonen.setWidget(0, 3, null);
				}
				@Override
				public void onFailure(Throwable caught) {
				}
			});
		}
	};
	private static ClickHandler chp = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			if(raum.id != -1){
				int lastrow = gridPersonen.getRowCount();
				Button btnDelPerson = new Button("-");
				btnDelPerson.setTitle(""+raum.id+" "+lastrow);
				btnDelPerson.addClickHandler(chm);

				String[] splitresult = lbResult.getValue(lbResult.getSelectedIndex()).split(" ");
				gridPersonen.resizeRows(lastrow+1);

				gridPersonen.setWidget(lastrow, 0, btnDelPerson);
				gridPersonen.setText(lastrow, 1, splitresult[0]);
				gridPersonen.setText(lastrow, 2, splitresult[1]);
				gridPersonen.setText(lastrow, 3, splitresult[2]);
				
				gridPersonen.setWidget(0, 0, btnSuchen);
				gridPersonen.setWidget(0, 1, txtVorname);
				gridPersonen.setWidget(0, 2, txtNachname);
				gridPersonen.setWidget(0, 3, txtTitel);

				update.Util.getInstance().person_zu_raum(Integer.parseInt(splitresult[3]), raum.id, new AsyncCallback<Void>() {
					@Override
					public void onSuccess(Void result) {
					}
					@Override
					public void onFailure(Throwable caught) {
						int lastrow = gridPersonen.getRowCount();
						gridPersonen.removeRow(lastrow);
					}
				});
			} else {
				System.out.println("KnotenInfo(): raum.id ist null");
			}
		}
	};
	private static ClickHandler chc = new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			
			gridPersonen.setWidget(0, 0, btnSuchen);
			gridPersonen.setWidget(0, 1, txtVorname);
			gridPersonen.setWidget(0, 2, txtNachname);
			gridPersonen.setWidget(0, 3, txtTitel);
		}
	};
	/**
	 * Initialisiert die angezeigten Details zu dem entsprechenden Raum 
	 * @param context
	 * 	Koordinaten des zu bearbeitenden Raums
	 * @param niveau
	 *  Niveau des zu bearbeitenden Raums
	 */
	public KnotenInfo(LatLng context, int niveau) {
		txtName.setText("");
		if(first){
			initHandlers();
			first = false;
		}
		update.Util.getInstance().getRaumInfoByLatLng(context.getLatitude(), context.getLongitude(), niveau, new AsyncCallback<Raum>() {
			@Override
			public void onSuccess(Raum result) {
				raum = result;
				if(null != raum.name){
					txtName.setText(raum.name);
					lbTyp.setSelectedIndex(raum.typ);
					update.Util.getInstance().getPersonbyRID(raum.id, new AsyncCallback<Person[]>() {
						
						@Override
						public void onSuccess(Person[] result) {
							System.out.println("KnotenInfo(): Personenzahl="+result.length);
							gridPersonen=new Grid((result.length+1), 4);
							System.out.println("KnotenInfo(): Grid Size="+gridPersonen.getRowCount());
							for(int i = 0;i<result.length;i++){
								System.out.println("KnotenInfo() for i="+i);
								Button btnDelPerson = new Button("-");
								btnDelPerson.setTitle(""+result[i].id+" "+(i+1));
								btnDelPerson.addClickHandler(chm);
								
								gridPersonen.setWidget(i+1, 0, btnDelPerson);
								gridPersonen.setText(i+1, 1, result[i].vorname);
								gridPersonen.setText(i+1, 2, result[i].nachname);
								gridPersonen.setText(i+1, 3, result[i].titel);
							}
							gridPersonen.setWidget(0, 0, btnSuchen);
							gridPersonen.setWidget(0, 1, txtVorname);
							gridPersonen.setWidget(0, 2, txtNachname);
							gridPersonen.setWidget(0, 3, txtTitel);
							panel.add(gridPersonen);
						}
						
						@Override
						public void onFailure(Throwable caught) {
						}

						
					});
					
				} else {
					gridPersonen = new Grid(1,4);
					gridPersonen.setWidget(0, 0, btnSuchen);
					gridPersonen.setWidget(0, 1, txtVorname);
					gridPersonen.setWidget(0, 2, txtNachname);
					gridPersonen.setWidget(0, 3, txtTitel);
					panel.add(gridPersonen);
				}
				
				
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});

		lbTyp = new ListBox();
		lbTyp.addItem("Buero");
		lbTyp.addItem("Hoersaal");
		lbTyp.addItem("Seminarraum");
		lbTyp.setVisibleItemCount(1);
		
		grid = new Grid(3,2);
		grid.setWidget(0, 0, btnSpeichern);
		grid.setWidget(0, 1, null);
		
		grid.setWidget(1, 0, lblName);
		grid.setWidget(1, 1, txtName);
		
		grid.setWidget(2, 0, lblTyp);
		grid.setWidget(2, 1, lbTyp);

		panel = new VerticalPanel();

		txtVorname.setText("Vorname");
		txtNachname.setText("Nachname");
		txtTitel.setText("Titel");

		panel.add(grid);
		panel.setSize("300px", "300px");
		initWidget(panel);
	}
	private void initHandlers(){
		btnSpeichern.addClickHandler(chsp);
		btnSuchen.addClickHandler(chs);
		btnPlus.addClickHandler(chp);
		btnClear.addClickHandler(chc);
	}
}
