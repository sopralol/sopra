package com.mycompany.project.client;

import com.google.gwt.maps.client.Copyright;
import com.google.gwt.maps.client.CopyrightCollection;
import com.google.gwt.maps.client.MapType;
import com.google.gwt.maps.client.MapUIOptions;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.TileLayer;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.control.MapTypeControl;
import com.google.gwt.maps.client.control.SmallMapControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.geom.LatLngBounds;
import com.google.gwt.maps.client.geom.MercatorProjection;
import com.google.gwt.maps.client.geom.Point;
import com.google.gwt.maps.client.geom.Size;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class KarteFlx extends Composite{
	static SimpleLayoutPanel a=new SimpleLayoutPanel();
	static String niveau="Niveau1";
	static int i=0;
	MapWidget map;
	public KarteFlx(){
		
		map = new MapWidget(LatLng.newInstance(33.7814790, -84.3880580),2);
	    map.setSize("585px", "585px");
	    
	    CopyrightCollection myCopyright = new CopyrightCollection("");
	    myCopyright.addCopyright(new Copyright(1, LatLngBounds.newInstance(LatLng.newInstance(34,
	        -81), LatLng.newInstance(36, -79)), 10, ""));
	    
	    
	    
	    
	    	//die 5 Tilelayer Schleife gieng nicht wegen initialisierung
	    	TileLayer tileLayer1=new TileLayer(myCopyright, 1, 4){
	      @Override
	      public double getOpacity() {
	        return 1.0;
	      }

	      @Override
	      public String getTileURL(Point tile, int zoomLevel) {
	    	 
	    	 return "http://127.0.0.1/TileGroup0/"+"Niveau1/"+zoomLevel+"-"+tile.getX()+"-"+tile.getY()+".jpg"; 
	      }

	      @Override
	      public boolean isPng() {
	        return true;
	      }
	    };
    		TileLayer tileLayer2=new TileLayer(myCopyright, 1, 4){
  	      @Override
  	      public double getOpacity() {
  	        return 1.0;
  	      }

  	      @Override
  	      public String getTileURL(Point tile, int zoomLevel) {
  	    	 
  	    	 return "http://127.0.0.1/TileGroup0/"+"Niveau2/"+zoomLevel+"-"+tile.getX()+"-"+tile.getY()+".jpg"; 
  	      }

  	      @Override
  	      public boolean isPng() {
  	        return true;
  	      }
  	    };
  		TileLayer tileLayer3=new TileLayer(myCopyright, 1, 4){
  	      @Override
  	      public double getOpacity() {
  	        return 1.0;
  	      }

  	      @Override
  	      public String getTileURL(Point tile, int zoomLevel) {
  	    	 
  	    	 return "http://127.0.0.1/TileGroup0/"+"Niveau3/"+zoomLevel+"-"+tile.getX()+"-"+tile.getY()+".jpg"; 
  	      }

  	      @Override
  	      public boolean isPng() {
  	        return true;
  	      }
  	    };
  		TileLayer tileLayer4=new TileLayer(myCopyright, 1, 4){
  	      @Override
  	      public double getOpacity() {
  	        return 1.0;
  	      }

  	      @Override
  	      public String getTileURL(Point tile, int zoomLevel) {
  	    	 
  	    	 return "http://127.0.0.1/TileGroup0/"+"Niveau4/"+zoomLevel+"-"+tile.getX()+"-"+tile.getY()+".jpg"; 
  	      }

  	      @Override
  	      public boolean isPng() {
  	        return true;
  	      }
  	    };
  		TileLayer tileLayer5=new TileLayer(myCopyright, 1, 4){
  	      @Override
  	      public double getOpacity() {
  	        return 1.0;
  	      }

  	      @Override
  	      public String getTileURL(Point tile, int zoomLevel) {
  	    	 
  	    	 return "http://127.0.0.1/TileGroup0/"+"Niveau5/"+zoomLevel+"-"+tile.getX()+"-"+tile.getY()+".jpg"; 
  	      }

  	      @Override
  	      public boolean isPng() {
  	        return true;
  	      }
  	    };
  	    //MapTypes und adden 
  	    MapType  mapNiv1=new MapType(new TileLayer[] {tileLayer1},
		        new MercatorProjection(20), "Niveau 1");
	    map.addMapType(mapNiv1);
	    MapType  mapNiv2=new MapType(new TileLayer[] {tileLayer2},
		        new MercatorProjection(20), "Niveau 2");
	    map.addMapType(mapNiv2);
	    MapType  mapNiv3=new MapType(new TileLayer[] {tileLayer3},
		        new MercatorProjection(20), "Niveau 3");
	    map.addMapType(mapNiv3);
	    MapType  mapNiv4=new MapType(new TileLayer[] {tileLayer4},
		        new MercatorProjection(20), "Niveau 4");
	    map.addMapType(mapNiv4);
	    MapType  mapNiv5=new MapType(new TileLayer[] {tileLayer5},
		        new MercatorProjection(20), "Niveau 5");
	    map.addMapType(mapNiv5);
	    map.setCurrentMapType(mapNiv2);
	    map.setZoomLevel(1);
	    
//	    MapType Niveau2 = 
//	    MapType Niveau3 = new MapType(new TileLayer[] {tileLayer},
//		        new MercatorProjection(20), "Uni Ulm - Niveau 3");
//	    MapType Niveau4 = new MapType(new TileLayer[] {tileLayer},
//		        new MercatorProjection(20), "Uni Ulm - Niveau 4");
//	    MapType Niveau5 = new MapType(new TileLayer[] {tileLayer},
//		        new MercatorProjection(20), "Uni Ulm - Niveau 5");
//		    
		
//	    
//	    map.addMapType(Niveau2);
//	    map.addMapType(Niveau3);
//	    map.addMapType(Niveau4);
//	    map.addMapType(Niveau5);
	   map.removeMapType(MapType.getNormalMap());
	   map.removeMapType(MapType.getSatelliteMap());
	   map.removeMapType(MapType.getHybridMap());
//	    map.addControl(new LargeMapControl());
	    map.addControl(new MapTypeControl());
	    
	    map.addControl(new MapTypeControl());
	    Size smallSize = Size.newInstance(250, 250);
	    MapUIOptions options=MapUIOptions.newInstance(smallSize);
	    options.setScrollwheel(true);
	    options.setHybridMapType(false);
	    options.setMapTypeControl(false);
	    options.setMenuMapTypeControl(false);
	    options.setPhysicalMapType(false);
	    options.setNormalMapType(false);
	    options.setSatelliteMapType(false);
	    options.setScaleControl(true);
	    options.setSmallZoomControl3d(true);
	    options.setLargeMapControl3d(true);
	    
	    map.setUI(options);
	    a.add(map);
	    	
	  initWidget(a);
	}

}
