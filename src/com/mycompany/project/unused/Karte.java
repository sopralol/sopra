/*package com.mycompany.project.unused;

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
import com.mycompany.project.client.Layers;

public class Karte extends Composite{
	static SimpleLayoutPanel a=new SimpleLayoutPanel();
	static String niveau="Niveau1";
	static int i=0;
	MapWidget map;
	public Karte(){
		
		map = new MapWidget(LatLng.newInstance(33.7814790, -84.3880580),2);
	    map.setSize("585px", "585px");
	    
 	    Layers layers = new Layers(); 
  	    MapType  maptype=new MapType(layers.layers,
		        new MercatorProjection(20), "Niveaus");
	    map.addMapType(maptype);
	    map.removeMapType(MapType.getNormalMap());
	    map.removeMapType(MapType.getSatelliteMap());
	    map.removeMapType(MapType.getHybridMap());
	    MapTypeControl mtc = new MapTypeControl();
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
*/