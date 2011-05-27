/*package com.mycompany.project.unused;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.CheckBox;

public class Loeschen extends PopupPanel {

	public Loeschen() {
		super(true);
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);		
		absolutePanel.setSize("630px", "650px");
		
		Button button = new Button("New button");
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.confirm("Wollen sie die ausgewaehlten Knoten wirklich Loeschen?");
				Loeschen.this.setVisible(false);
				
			}
		});
		button.setText("l\u00F6schen");
		absolutePanel.add(button, 520, 0);
		button.setSize("100px", "28px");
		
		Button button_1 = new Button("New button");
		button_1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Loeschen.this.setVisible(false);
				new TempDeaktivieren().center();
			}
		});
		button_1.setText("Tempor\u00E4r deaktivieren");
		absolutePanel.add(button_1, 344, 0);
		button_1.setSize("170px", "28px");
		
		Label lblAusgewhlteKnoten = new Label("Ausgew\u00E4hlte Knoten :");
		lblAusgewhlteKnoten.setStyleName("body");
		lblAusgewhlteKnoten.setDirection(Direction.LTR);
		absolutePanel.add(lblAusgewhlteKnoten, 209, 12);
		lblAusgewhlteKnoten.setSize("129px", "16px");
		
		Karte karte = new Karte();
		absolutePanel.add(karte, 10, 34);
		
		CheckBox chckbxH = new CheckBox("H20");
		chckbxH.setValue(true);
		chckbxH.setStyleName("headings");
		absolutePanel.add(chckbxH, 470, 493);
		
		CheckBox chckbxMensa = new CheckBox("Mensa");
		chckbxMensa.setStyleName("headings");
		absolutePanel.add(chckbxMensa, 181, 539);
		
		CheckBox chckbxH_1 = new CheckBox("H3");
		chckbxH_1.setStyleName("headings");
		absolutePanel.add(chckbxH_1, 314, 364);
		
		CheckBox chckbxH_2 = new CheckBox("H2");
		chckbxH_2.setStyleName("headings");
		absolutePanel.add(chckbxH_2, 290, 380);
		
		CheckBox chckbxH_3 = new CheckBox("H1");
		chckbxH_3.setStyleName("headings");
		absolutePanel.add(chckbxH_3, 290, 416);
		
		Button button_2 = new Button("New button");
		button_2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Loeschen.this.setVisible(false);
				new EingabeLoeschen().center();
			}
		});
		button_2.setText("Raumnummern eingeben");
		absolutePanel.add(button_2, 10, 0);
		button_2.setSize("193px", "28px");

	}
}
*/