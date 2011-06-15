package com.mycompany.project.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mycompany.project.server.DBconn;


@RemoteServiceRelativePath("update")
public interface update extends RemoteService {
	void knoten_einfuegen(double lat,double lng,int typ,int niveau);
	void knoten_loeschen(double lat, double lng,int niv);
	void knoten_loeschen_all(double lat, double lng);
	Knoten[] knoten_auslesen(int niveau);	
	Knoten[] knoten_auslesennot(int niveau,double lat, double lng);
	
	void kante_einfuegen(double lat1,double lng1,double lat2,double lng2,int gewicht,int niveau);
	void kante_loeschen(double lat1,double lng1,double lat2,double lng2, int niveau);
	Kante[] kanten_auslesen(int niveau);
	Kante[] kanten_auslesennot(int niveau,double lat, double lng);
	
	void person_einfuegen(String vorname,String nachname,String email,String telefon,String institut,String titel);
	Person[] person_suchen(String vorname, String nachname, String institut, String titel);
	void person_loeschen(String pid);
	void person_aendern(String pid,String vorname,String nachname,String email,String telefon,String institut,String titel);
	
	Raum getRaumInfoByLatLng(double lat, double lng, int niveau);
	void raum_aendern(int typ, String name, int id );
	Integer raum_einfuegen(int typ, String name, int kid );
	
	Person[] getPersonbyRID(int rid);
	void person_zu_raum(int pid, int rid);
	void person_von_raum(int pid);

	
	
	
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static updateAsync instance;
		public static updateAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(update.class);
			}
			return instance;
		}
	}
}
