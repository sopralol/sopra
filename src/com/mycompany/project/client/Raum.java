package com.mycompany.project.client;

import com.google.gwt.user.client.rpc.IsSerializable;
/**
 * Klasse zum Speichern von Raumdaten
 * @author Martin Zellner
 * @author David Schmid
 * 
 * 
 */

public class Raum implements IsSerializable {
	int id;
	int kid;
	String name;
	int typ;
	public Raum(){};;;;;;;;;;;;;;;;;; //weils geht
	public Raum(int id, int kid, String name, int typ) {
		super();
		this.id = id;
		this.kid = kid;
		this.name = name;
		this.typ = typ;
	}
	public Raum(int kid) {
		super();
		this.kid = kid;
		this.id=-1;
		this.name = null;
	}
	

	
}
