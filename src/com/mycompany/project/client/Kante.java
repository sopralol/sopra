package com.mycompany.project.client;

import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Kante implements IsSerializable {
	public int gewicht,niveau;
	public double lat1,lng1, lat2,lng2;
	
	Kante(){}

	public Kante( double lat1, double lng1,
			double lat2, double lng2,int gewicht, int niveau) {
		super();
		this.gewicht = gewicht;
		this.niveau = niveau;
		this.lat1 = lat1;
		this.lng1 = lng1;
		this.lat2 = lat2;
		this.lng2 = lng2;
	};

	
}
