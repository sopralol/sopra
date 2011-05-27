/*package com.mycompany.project.unused;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Label;
import com.mycompany.project.client.Eingeben;

public class Karte extends Composite {
	
	static Image image = new Image("hs-uu.jpg");
	static Image image_1 = new Image("hs-uu.jpg");
	static Image image_2= new Image("hs-uu.jpg");
	static Image image_3 = new Image("hs-uu.jpg");
	static Image image_4 = new Image("hs-uu.jpg");
	static Label label = new Label("Start");
	public Karte() {
		
		final AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("610", "610");
		
		TabLayoutPanel tabLayoutPanel = new TabLayoutPanel(1.5, Unit.EM);
		
		
		image.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {//popup einf�gen anzeigen
				if(Eingeben.radiobtnRaumEintragen.isChecked())
					{
					Einfpop.setstart(event.getX(), event.getY());
					new Einfpop().center();
					
					}
				}
		});
		image.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// 
			if(Eingeben.radiobtnEintragen.isChecked()){
				
				Eingeben.setstart(event.getX(),event.getY());
			}
			}
		});
		
		image.setAltText("Niveau 1");
		tabLayoutPanel.add(image, "Niveau 1", false);
		image.setSize("590px", "570px");
		
		image_1 = new Image("hs-uu.jpg");
		tabLayoutPanel.add(image_1, "Niveau 2", false);
		image_1.setSize("590px", "570px");
		
		image_2 = new Image("hs-uu.jpg");
		tabLayoutPanel.add(image_2, "Niveau 3", false);
		image_2.setSize("590px", "570px");
		
		image_3 = new Image("hs-uu.jpg");
		tabLayoutPanel.add(image_3, "Niveau 4", false);
		image_3.setSize("590px", "570px");
		
		image_4 = new Image("hs-uu.jpg");
		tabLayoutPanel.add(image_4, "Niveau 5", false);
		image_4.setSize("590px", "570px");
		absolutePanel.add(tabLayoutPanel, 0, 0);
		tabLayoutPanel.setSize("610px", "610px");
		
		Navi navi = new Navi();
		absolutePanel.add(navi,497,20);
		navi.setSize("107px", "201px");
		
		
		
		
		
		
		
	}
}
*/