package com.mycompany.project.client;


import com.google.gwt.user.client.rpc.IsSerializable;

public class Knoten implements IsSerializable {
	
	public int typ,niveau;
	public double lat,lng;
	Knoten(){};
	public Knoten(double lat, double lng, int typ, int niveau) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.typ = typ;
		this.niveau = niveau;
	}
}
	


