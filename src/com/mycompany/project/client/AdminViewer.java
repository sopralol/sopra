package com.mycompany.project.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
/**
 * Eintrittspunkt der Klasse die onModuleLoad definiert.
 * @author Martin Zellner
 * @author David Schmid
 * 
 * 
 *
 */
public class AdminViewer implements EntryPoint {
	
	static RootPanel rootPanel;
	static Auswahl auswahl = new Auswahl();
	private Button clickMeButton;

	@Override
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		rootPanel.add(absolutePanel, 10, 10);
		absolutePanel.setSize("430px", "280px");
		
		
		absolutePanel.add(auswahl, 20, 10);
		
		
	}
}
