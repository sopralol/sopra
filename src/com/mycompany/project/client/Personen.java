package com.mycompany.project.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
/**
 * Auswahl der Personenfunktionen.
 * @author Martin Zellner
 * @author David Schmid
 * 
 * 
 */

public class Personen extends PopupPanel {
	static Grid ergebnisGrid = new Grid();
	static VerticalPanel verticalpanel = new VerticalPanel();
	static ScrollPanel scrollpanel = new ScrollPanel();
	static HorizontalPanel horizontalpanel = new HorizontalPanel();
	static Button buttonSuchen = new Button("Suchen");
	static Button buttonEinfuegen = new Button("Einfuegen");
	static Button buttonAendern = new Button("Aendern");
	static Button buttonLoeschen = new Button("Loeschen");

	
	
	public Personen(){
		super(true);
		verticalpanel = new VerticalPanel();
		scrollpanel = new ScrollPanel();
		setSize("850px", "800px");
		
		
		buttonSuchen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				new PersonenSuche().center();

				
			}
		});
		buttonEinfuegen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				new PersonenEinfuegen().center();
				
			}
		});
		buttonLoeschen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				update.Util.getInstance().person_loeschen(PersonenSuche.selectedId.split(" ")[0], new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
				
			}
		});
		buttonAendern.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int gridid = Integer.parseInt(PersonenSuche.selectedId.split(" ")[1]);
				String perid = PersonenSuche.selectedId.split(" ")[0];
				new PersonAendern(perid, Personen.ergebnisGrid.getText(gridid, 1),  Personen.ergebnisGrid.getText(gridid, 2), 
						 Personen.ergebnisGrid.getText(gridid, 3), Personen.ergebnisGrid.getText(gridid, 4),
						 Personen.ergebnisGrid.getText(gridid, 5),  Personen.ergebnisGrid.getText(gridid, 6)).center();				
			}
		});
		
		
		horizontalpanel.add(buttonSuchen);
		horizontalpanel.add(buttonEinfuegen);
		horizontalpanel.add(buttonAendern);
		horizontalpanel.add(buttonLoeschen);
		verticalpanel.add(horizontalpanel);
		scrollpanel.add(ergebnisGrid);
		verticalpanel.add(scrollpanel);
		verticalpanel.setCellHeight(horizontalpanel, "50px");
		add(verticalpanel);		
		
	}
	protected void onDetach() {
		super.onDetach();
		Window.Location.reload();
	}
}
