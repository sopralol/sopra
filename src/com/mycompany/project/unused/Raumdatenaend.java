package com.mycompany.project.unused;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

public class Raumdatenaend extends PopupPanel {

	public Raumdatenaend() {
		super(true);
		
		Grid grid = new Grid(6, 2);
		setWidget(grid);
		grid.setSize("300", "100%");
		
		Label lblName = new Label("Raum Nr.");
		grid.setWidget(0, 0, lblName);
		grid.getCellFormatter().setWidth(0, 0, "150");
		
		TextBox textBox = new TextBox();
		grid.setWidget(0, 1, textBox);
		grid.getCellFormatter().setWidth(0, 1, "150");
		
		Label lblGebudekreuz = new Label("Geb\u00E4udekreuz");
		grid.setWidget(1, 0, lblGebudekreuz);
		
		TextBox textBox_1 = new TextBox();
		grid.setWidget(1, 1, textBox_1);
		
		Label lblAbteilung = new Label("Abteilung\r\n(leer beh\u00E4lt abteilung bei)");
		grid.setWidget(2, 0, lblAbteilung);
		
		TextBox textBox_2 = new TextBox();
		grid.setWidget(2, 1, textBox_2);
		
		Label lblName_1 = new Label("Name");
		grid.setWidget(3, 0, lblName_1);
		lblName_1.setWidth("150");
		
		TextBox textBox_3 = new TextBox();
		grid.setWidget(3, 1, textBox_3);
		
		Label lblVorname = new Label("Vorname");
		grid.setWidget(4, 0, lblVorname);
		lblVorname.setWidth("150");
		
		TextBox textBox_4 = new TextBox();
		grid.setWidget(4, 1, textBox_4);
		
		Button button = new Button("New button");
		button.setText("Eingeben");
		grid.setWidget(5, 0, button);
		
		Button button_1 = new Button("New button");
		button_1.setText("zur\u00FCck");
		grid.setWidget(5, 1, button_1);
	}

}
