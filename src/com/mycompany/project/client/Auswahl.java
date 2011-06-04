package com.mycompany.project.client;

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
public class Auswahl extends Composite {

	
	public Auswahl() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		
		Button button_0 = new Button("Karten Hochladen");
		Button button_1 = new Button("Kartendaten verwalten");
		Button button_2 = new Button("Personendaten verwalten");

		button_0.setWidth("400px");
		button_1.setWidth("400px");
		button_2.setWidth("400px");

		
		button_1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				new Eingeben().center();				
			}
		});
		

		button_2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			new Personen().center();
			}
		});
		
		verticalPanel.add(button_0);
		verticalPanel.add(button_1);
		verticalPanel.add(button_2);
	
	}

}

//testsss
