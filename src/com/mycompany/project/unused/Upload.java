package com.mycompany.project.unused;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Upload extends PopupPanel {

	public Upload() {
		super(true);
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("402px", "95px");
		
		Label lblKartenAdresse = new Label("Karten Adresse");
		absolutePanel.add(lblKartenAdresse, 10, 10);
		
		TextBox textBox = new TextBox();
		absolutePanel.add(textBox, 10, 32);
		textBox.setSize("380px", "16px");
		
		Button button = new Button("Upload");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Upload.this.setVisible(false);
			}
		});
		absolutePanel.add(button, 298, 62);
		button.setSize("100px", "28px");
		
		Button button_1 = new Button("Durchsuchen");
		absolutePanel.add(button_1, 192, 62);
		button_1.setSize("100px", "28px");
	}
}
