package com.mycompany.project.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;

public class PersonenEinfuegen extends PopupPanel {
	static TextBox txtVorname = new TextBox();
	static TextBox txtNachname = new TextBox();
	static TextBox txtEmail = new TextBox();
	static TextBox txtTelefon = new TextBox();
	static TextBox txtInstitut = new TextBox();
	static TextBox txtTitel = new TextBox();

	public PersonenEinfuegen() {
		super();
		setSize("120px", "350px");
		

		Label lblVorname = new Label("Vorname:");
		Label lblNachname = new Label("Nachname:");
		Label lblEmail = new Label("Email:");
		Label lblTelefon = new Label("Telefon:");
		Label lblInstitut = new Label("Institut:");
		Label lblTitel = new Label("Titel:");
		Button btnEinfuegen = new Button("Einfuegen");
		Button btnAbbrechen= new Button("Abbrechen");
		Grid grid = new Grid(7, 2);
		grid.setWidget(0, 0,lblVorname );
		grid.setWidget(1, 0,lblNachname );
		grid.setWidget(2, 0,lblEmail );
		grid.setWidget(3, 0,lblTelefon );
		grid.setWidget(4, 0,lblInstitut );
		grid.setWidget(5, 0,lblTitel );
		grid.setWidget(6, 0, btnAbbrechen);
		grid.setWidget(0, 1,txtVorname );
		grid.setWidget(1, 1,txtNachname );
		grid.setWidget(2, 1,txtEmail );
		grid.setWidget(3, 1,txtTelefon );
		grid.setWidget(4, 1,txtInstitut );
		grid.setWidget(5, 1,txtTitel );
		grid.setWidget(6, 1, btnEinfuegen);
		
		setWidget(grid);
		btnEinfuegen.addClickHandler(new ClickHandler() {
			
			
			@Override
			public void onClick(ClickEvent event) {
				update.Util.getInstance().person_einfuegen(txtVorname.getValue(),txtNachname.getValue(),txtEmail.getValue(),
						txtTelefon.getValue(),txtInstitut.getValue(),txtTitel.getValue() ,new AsyncCallback<Void>() {
							
							@Override
							public void onSuccess(Void result) {
								hide();
								
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
