package com.mycompany.project.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
/*import com.mycompany.project.unused.Knotenaktual;
import com.mycompany.project.unused.Loeschen;
import com.mycompany.project.unused.Raumdatenaend;
import com.mycompany.project.unused.Upload;
*/
/**
 * Hauptauswahl.
 * @author Martin Zellner
 * @author David Schmid
 * 
 * 
 */

public class Auswahl extends Composite {

	static VerticalPanel verticalPanel = new VerticalPanel();
	static Button button_0 = new Button("URL zu Karten einstellen");
	static Button button_1 = new Button("Kartendaten verwalten");
	static Button button_2 = new Button("Personendaten verwalten");
	static String urlstring;
	public Auswahl() {
		
		initWidget(verticalPanel);

		button_0.setWidth("400px");
		button_1.setWidth("400px");
		button_2.setWidth("400px");

		button_0.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				verticalPanel.remove(button_0);
				verticalPanel.remove(button_1);
				verticalPanel.remove(button_2);
				new Kartendaten().center();
			}
		});
		
		button_1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				verticalPanel.remove(button_0);
				verticalPanel.remove(button_1);
				verticalPanel.remove(button_2);
				new Eingeben().center();				
			}
		});
		

		button_2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				verticalPanel.remove(button_0);
				verticalPanel.remove(button_1);
				verticalPanel.remove(button_2);

			new Personen().center();
			}
		});
		
		update.Util.getInstance().gib_url(new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				urlstring = new String(result);
				verticalPanel.add(button_0);
				verticalPanel.add(button_1);
				verticalPanel.add(button_2);
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
