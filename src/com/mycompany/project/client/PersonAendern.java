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

public class PersonAendern extends PopupPanel {
	static TextBox txtVorname = new TextBox();
	static TextBox txtNachname = new TextBox();
	static TextBox txtInstitut = new TextBox();
	static TextBox txtTitel = new TextBox();
	static TextBox txtTelefon = new TextBox();
	static TextBox txtEmail = new TextBox();
	static String id = "";
	public PersonAendern(String pid,String vorname,String nachname,String email,String telefon,String institut,String titel) {
		super();
		setSize("120px", "350px");
		id = pid;
		Label lblVorname = new Label("Vorname:");
		Label lblNachname = new Label("Nachname:");
		Label lblInstitut = new Label("Institut:");
		Label lblTitel = new Label("Titel:");
		Label lblTelefon = new Label("Telefon:");
		Label lblEmail = new Label("E-Mail:");
		txtVorname.setText(vorname);
		txtNachname.setText(nachname);
		txtInstitut.setText(institut);
		txtTitel.setText(titel);
		txtTelefon.setText(telefon);
		txtEmail.setText(email);
		Button btnSpeichern = new Button("Speichern");
		Button btnAbbrechen= new Button("Abbrechen");
		Grid grid = new Grid(7, 2);
		grid.setWidget(0, 0,lblVorname );
		grid.setWidget(1, 0,lblNachname );
		grid.setWidget(2, 0,lblInstitut );
		grid.setWidget(3, 0,lblTitel );
		grid.setWidget(4, 0,lblTelefon );
		grid.setWidget(5, 0,lblEmail );
		grid.setWidget(6, 0, btnAbbrechen);
		grid.setWidget(0, 1,txtVorname );
		grid.setWidget(1, 1,txtNachname );
		grid.setWidget(2, 1,txtInstitut );
		grid.setWidget(3, 1,txtTitel );
		grid.setWidget(4, 1,txtTelefon );
		grid.setWidget(5, 1,txtEmail );
		grid.setWidget(6, 1, btnSpeichern);
		
		setWidget(grid);
		btnSpeichern.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				update.Util.getInstance().person_aendern(id, txtVorname.getText(), txtNachname.getText(), txtEmail.getText(), txtTelefon.getText(), txtInstitut.getText(), txtTitel.getText(), new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						hide();
					}
					
					@Override
					public void onFailure(Throwable caught) {						
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
