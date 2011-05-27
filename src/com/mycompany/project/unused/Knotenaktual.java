/*package com.mycompany.project.unused;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Knotenaktual extends PopupPanel {

	public Knotenaktual() {
		super(true);
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("624px", "662px");
		
		Karte karte = new Karte();
		absolutePanel.add(karte, 10, 44);
		
		Button button = new Button("New button");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				new Einfpop().show();
			}
		});
		button.setText("Knoten eingeben");
		absolutePanel.add(button, 10, 10);
		button.setSize("115px", "28px");
		
		Button button_1 = new Button("New button");
		button_1.setText("Ausgew\u00E4hlten Knoten \u00E4ndern");
		absolutePanel.add(button_1, 131, 10);
		button_1.setSize("219px", "28px");
	}
}
*/