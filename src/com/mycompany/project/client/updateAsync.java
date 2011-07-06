package com.mycompany.project.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * enthaelt Asynchrone Methoden fuer RPC Calls
 * @author David Schmid
 * @author Martin Zellner
 *
 */
public interface updateAsync {
	void knoten_einfuegen(double lat,double lng,int typ,int niveau, AsyncCallback<Void> callback);
	void knoten_loeschen(double lat, double lng,int niv, AsyncCallback<Void> callback);
	void knoten_loeschen_all(double lat, double lng, AsyncCallback<Void> callback);
	void knoten_auslesen(int niveau, AsyncCallback<Knoten[]> callback);
	void knoten_auslesennot(int niveau,double lat, double lng, AsyncCallback<Knoten[]> callback);


	void kante_einfuegen(double lat1,double lng1,double lat2,double lng2,int gewicht,int niveau,AsyncCallback<Void> callback);
	void kante_loeschen(double lat1,double lng1,double lat2,double lng2,int niveau,AsyncCallback<Void> callback);
	void kanten_auslesen(int niveau, AsyncCallback<Kante[]> callback);
	void kanten_auslesennot(int niveau,double lat, double lng, AsyncCallback<Kante[]> callback);
	
	void person_einfuegen(String vorname,String nachname,String email,String telefon,String institut,String titel,AsyncCallback<Void> callback);
	void person_suchen(String vorname, String nachname, String institut, String titel, AsyncCallback<Person[]> callback);
	void person_loeschen(String pid, AsyncCallback<Void> callback);
	void person_aendern(String pid,String vorname,String nachname,String email,String telefon,String institut,String titel,AsyncCallback<Void> callback);
	
	void getRaumInfoByLatLng(double lat, double lng, int niveau, AsyncCallback<Raum> callback);
	void raum_aendern(int typ, String name, int id, AsyncCallback<Void> callback);
	void raum_einfuegen(int typ, String name, int kid, AsyncCallback<Integer> callback);
	
	void getPersonbyRID(int rid, AsyncCallback<Person[]> callback);
	void person_zu_raum(int pid, int rid,AsyncCallback<Void> callback);
	void person_von_raum(int pid,AsyncCallback<Void> callback);

	void gib_url(AsyncCallback<String> callback);
	void mach_url(String url,AsyncCallback<Void> callback);
}
