package com.mycompany.project.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.mysql.jdbc.log.Log;
/**
 * Klasse zum Suchen von Personen
 * @author Martin Zellner
 * @author David Schmid
 * 
 * 
 */

public class PersonenSuche extends PopupPanel {

	static TextBox txtVorname = new TextBox();
	static TextBox txtNachname = new TextBox();
	static TextBox txtInstitut = new TextBox();
	static TextBox txtTitel = new TextBox();
	static String selectedId = "";
	public PersonenSuche() {
		
		super();
		setSize("120px", "350px");
		
		Label lblVorname = new Label("Vorname:");
		Label lblNachname = new Label("Nachname:");
		Label lblInstitut = new Label("Institut:");
		Label lblTitel = new Label("Titel:");
		Button btnSuchen = new Button("Suchen");
		Button btnAbbrechen= new Button("Abbrechen");
		Grid grid = new Grid(5, 2);
		grid.setWidget(0, 0,lblVorname );
		grid.setWidget(1, 0,lblNachname );
		grid.setWidget(2, 0,lblInstitut );
		grid.setWidget(3, 0,lblTitel );
		grid.setWidget(4, 0, btnAbbrechen);
		grid.setWidget(0, 1,txtVorname );
		grid.setWidget(1, 1,txtNachname );
		grid.setWidget(2, 1,txtInstitut );
		grid.setWidget(3, 1,txtTitel );
		grid.setWidget(4, 1, btnSuchen);
		
		setWidget(grid);
		btnSuchen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide();
				update.Util.getInstance().person_suchen(txtVorname.getValue(), txtNachname.getValue(), txtInstitut.getValue(), txtTitel.getValue(), new AsyncCallback<Person[]>() {
					
					@Override
					public void onSuccess(Person[] result) {
						System.out.println(""+result.length);
						Personen.scrollpanel.remove(Personen.ergebnisGrid);
						RadioButton[] radiobuttons = new RadioButton[result.length];
						
						Personen.ergebnisGrid = new Grid(result.length+1, 7);
						Personen.ergebnisGrid.setBorderWidth(1);
						Personen.ergebnisGrid.setWidth("90%");
						Personen.ergebnisGrid.setText(0, 1, "Vorname");
						Personen.ergebnisGrid.setText(0, 2, "Nachname");
						Personen.ergebnisGrid.setText(0, 3, "E-Mail");
						Personen.ergebnisGrid.setText(0, 4, "Telefon");
						Personen.ergebnisGrid.setText(0, 5, "Institut");
						Personen.ergebnisGrid.setText(0, 6, "Titel");
						for (int i=1; i<result.length+1;i++){
							radiobuttons[i-1] = new RadioButton("choice");
							radiobuttons[i-1].setFormValue(""+result[i-1].id+" "+i);
							Personen.ergebnisGrid.setWidget(i, 0, radiobuttons[i-1]);
//							Personen.ergebnisGrid.setText(i, 1, "leer"/*""+result[i-1].kid+" "+(i-1)*/);
							Personen.ergebnisGrid.setText(i, 1, result[i-1].vorname);
							Personen.ergebnisGrid.setText(i, 2, result[i-1].nachname);
							Personen.ergebnisGrid.setText(i, 3, result[i-1].email);
							Personen.ergebnisGrid.setText(i, 4, result[i-1].telefon);
							Personen.ergebnisGrid.setText(i, 5, result[i-1].institut);
							Personen.ergebnisGrid.setText(i, 6, result[i-1].titel);
							radiobuttons[i-1].addClickHandler(new ClickHandler() {
								
								@Override
								public void onClick(ClickEvent event) {
									selectedId = ((RadioButton)event.getSource()).getFormValue();
								}
							});
						}
						
						Personen.scrollpanel.add(Personen.ergebnisGrid);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
				
			}
		});
		btnAbbrechen.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide();
				
			}
		});

		
	}
}
