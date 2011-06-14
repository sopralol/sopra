package com.mycompany.project.server;

import com.mycompany.project.client.Kante;
import com.mycompany.project.client.Knoten;
import com.mycompany.project.client.Person;
import com.mycompany.project.client.Raum;
import com.mycompany.project.client.update;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class updateImpl extends RemoteServiceServlet implements update {

	@Override
	public void knoten_einfuegen(double lat, double lng, int typ, int niveau) {
		Knoten x = new Knoten(lat, lng, typ, niveau);
		DBconn.saveKnoten(x);
	}
	public void knoten_loeschen(double lat,double lng,int niv){
		DBconn.deleteKnoten(lat,lng,niv);
	}
	public void knoten_loeschen_all(double lat,double lng){
		DBconn.deleteKnoten(lat,lng);
	}
	public Knoten[] knoten_auslesen (int niv){
		return DBconn.readKnoten(niv);
		
	}
	public Knoten[] knoten_auslesennot(int niv,double lat, double lng){
		return DBconn.readKnotennot(niv,lat,lng);
	}

	
	
	
	public void kante_loeschen(double lat1,double lng1, double lat2,double lng2, int niv){
		DBconn.deleteKante(lat1,lng1,lat2,lng2,niv);
	}
	public void kante_einfuegen(double lat1, double lng1,double lat2, double lng2, int gewicht, int niveau) {
		Kante x = new Kante(lat1, lng1, lat2, lng2, gewicht, niveau);
		DBconn.saveKante(x);
	}
	public Kante[] kanten_auslesen(int niv){
		return DBconn.readKante(niv);
	}
	public Kante[] kanten_auslesennot(int niv,double lat, double lng){
		return DBconn.readKantenot(niv,lat,lng);
	}
	
	public void person_einfuegen(String vorname,String nachname,String email,String telefon,String institut,String titel){
		DBconn.insertPerson(vorname, nachname, email, telefon, institut, titel);
	}
	public Person[] person_suchen(String vorname, String nachname, String institut, String titel){
		return DBconn.searchPerson(vorname, nachname, institut, titel);
	}
	public void person_loeschen(String pid){
		DBconn.deletePerson(pid);
	}
	public void person_aendern(String pid,String vorname,String nachname,String email,String telefon,String institut,String titel){
		DBconn.updatePerson(pid,vorname, nachname, email, telefon, institut, titel);
	}
	public Raum getRaumInfoByLatLng(double lat, double lng, int niveau){
		return DBconn.getRaumInfoByLatLng(lat, lng, niveau);
	}
	public Person[] getPersonbyRID(int rid){
		return DBconn.getPersonenbyRID(rid);
	}
}
