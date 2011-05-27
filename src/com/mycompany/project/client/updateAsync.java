package com.mycompany.project.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface updateAsync {
	void knoten_einfuegen(double lat,double lng,int typ,int niveau, AsyncCallback<Void> callback);
	void knoten_loeschen(double lat, double lng, AsyncCallback<Void> callback);
	void knoten_auslesen(int niveau, AsyncCallback<Knoten[]> callback);
	void knoten_auslesennot(int niveau,double lat, double lng, AsyncCallback<Knoten[]> callback);


	void kante_einfuegen(double lat1,double lng1,double lat2,double lng2,int gewicht,int niveau,AsyncCallback<Void> callback);
	void kante_loeschen(double lat1,double lng1,double lat2,double lng2,AsyncCallback<Void> callback);
	void kanten_auslesen(int niveau, AsyncCallback<Kante[]> callback);
	void kanten_auslesennot(int niveau,double lat, double lng, AsyncCallback<Kante[]> callback);
	
	void person_einfuegen(String vorname,String nachname,String email,String telefon,String institut,String titel,AsyncCallback<Void> callback);
	void person_suchen(String vorname, String nachname, String institut, String titel, AsyncCallback<Person[]> callback);


}
