package com.mycompany.project.client;

import com.google.gwt.user.client.rpc.IsSerializable;
/**
 * Serialisierbare Klasse zum Speichern von Personendaten
 * @author Martin Zellner
 * @author David Schmid
 * 
 * 
 */

public class Person implements IsSerializable {

	int id, kid;
	String vorname,nachname,email,telefon,institut,titel;


	public Person() {
		super();
	}


	public Person(int id, int kid, String vorname, String nachname,
			String email, String telefon, String institut, String titel) {
		super();
		this.id = id;
		this.kid = kid;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.telefon = telefon;
		this.institut = institut;
		this.titel = titel;
	}
	
	@Override
	public String toString() {
		return vorname+" "+nachname+" "+titel+" "+id;
	}
}
