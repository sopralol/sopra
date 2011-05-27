/*package com.mycompany.project.unused;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.mycompany.project.client.Eingeben;
import com.mycompany.project.client.update;
import com.mycompany.project.client.update.Util;


public class Einfpop extends PopupPanel {
	static int x,y;
	static void setstart(int x1,int y1){
		y=y1+60;
		x=x1;
		
	}
	static Label lblGebudekreuz;
static TextBox textBox_gebaeude;
	
	TextBox textBox = new TextBox();
	public Einfpop() {
		super(true);
		
		Grid grid = new Grid(6, 2);
		setWidget(grid);
		grid.setSize("100", "100%");
		
		Label lblRaumnr = new Label("Raumnr");
		grid.setWidget(0, 0, lblRaumnr);
		
		
		textBox.setFocus(true);
		grid.setWidget(0, 1, textBox);
		textBox.setText(Integer.toString(x));//test
		 lblGebudekreuz= new Label("Geb\u00E4udekreuz");
		grid.setWidget(1, 0, lblGebudekreuz);
		
		 textBox_gebaeude= new TextBox();
		grid.setWidget(1, 1, textBox_gebaeude);
		if(Eingeben.chckbxMitAbteilung.isChecked()){
		Label lblAbteilung = new Label("Abteilung");
		grid.setWidget(2, 0, lblAbteilung);
		
		TextBox textBox_4 = new TextBox();
		grid.setWidget(2, 1, textBox_4);
		}
		if(Eingeben.chckbxMitName.isChecked()){
		Label lblName = new Label("Name");
		grid.setWidget(3, 0, lblName);
		
		TextBox textBox_name = new TextBox();
		grid.setWidget(3, 1, textBox_name);
		
		Label lblVorname = new Label("Vorname");
		grid.setWidget(4, 0, lblVorname);
		
		TextBox textBox_vname = new TextBox();
		grid.setWidget(4, 1, textBox_vname);
		}
		Button button_1 = new Button("New button");
		button_1.setText("Eintragen");
		grid.setWidget(5, 0, button_1);
		grid.getCellFormatter().setWidth(5, 0, "70");
		button_1.setWidth("70");
		
		Button button = new Button("New button");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			Einfpop.this.setVisible(false);
			}
		});
		button_1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Einfpop.this.setVisible(false);
				update.Util.getInstance().knoten_einfuegen(x, y, 1, 1, new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
			}
		});
		button.setText("Zur\u00FCck");
		grid.setWidget(5, 1, button);
		grid.getCellFormatter().setWidth(5, 1, "98");
	}

}
*/