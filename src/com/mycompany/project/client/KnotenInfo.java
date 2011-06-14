package com.mycompany.project.client;


import org.apache.tools.ant.taskdefs.Sleep;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class KnotenInfo extends Composite {
	static VerticalPanel panel;
	static boolean exists = false;
	static boolean first=true;
	static Grid grid;
	static Grid gridPersonen;
	static Raum raum;
	static Button btnSpeichern = new Button("Speichern");
	static Button btnAbbrechen = new Button("Abbrechen");
	static Button btnSuchen = new Button("S");
	static Button btnPlus = new Button("+");
	static Button btnClear = new Button("C");
	static Label lblName = new Label("Name/Nr.:");;
	static Label lblTyp = new Label("Raumtyp:");
	static TextBox txtName = new TextBox();
	static TextBox txtVorname = new TextBox();
	static TextBox txtNachname= new TextBox();
	static TextBox txtTitel = new TextBox();
	static ListBox lbTyp = new ListBox();
	static ListBox lbResult;
	static ClickHandler chs = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			update.Util.getInstance().person_suchen(txtVorname.getText(), txtNachname.getText(), "", txtTitel.getText(), new AsyncCallback<Person[]>() {
				@Override
				public void onSuccess(Person[] result) {
					lbResult = new ListBox();
					for (int i = 0; i < result.length; i++) {
						lbResult.addItem(result[i].toString());
					}
					lbResult.setVisibleItemCount(1);
					
					gridPersonen.setWidget(0, 0, btnPlus);
					gridPersonen.setWidget(0, 1, lbResult);
					
					gridPersonen.setWidget(0, 2, btnClear);
					gridPersonen.setWidget(0, 3, null);
				}
				@Override
				public void onFailure(Throwable caught) {
				}
			});
		}
	};
	static ClickHandler chp = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			Button delPerson = new Button("-");
			//TODO
			delPerson.setTitle("");

			int lastrow = gridPersonen.getRowCount();
			gridPersonen.resizeRows(lastrow+1);
			
			gridPersonen.setWidget(lastrow, 0, delPerson);
			String[] splitresult = lbResult.getValue(lbResult.getSelectedIndex()).split(" ");
			gridPersonen.setText(lastrow, 1, splitresult[0]);
			gridPersonen.setText(lastrow, 2, splitresult[1]);
			gridPersonen.setText(lastrow, 3, splitresult[2]);
			
			gridPersonen.setWidget(0, 0, btnSuchen);
			gridPersonen.setWidget(0, 1, txtVorname);
			gridPersonen.setWidget(0, 2, txtNachname);
			gridPersonen.setWidget(0, 3, txtTitel);
		}
	};
	static ClickHandler chc = new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			
			gridPersonen.setWidget(0, 0, btnSuchen);
			gridPersonen.setWidget(0, 1, txtVorname);
			gridPersonen.setWidget(0, 2, txtNachname);
			gridPersonen.setWidget(0, 3, txtTitel);
		}
	};

	public KnotenInfo(LatLng context, int niveau) {
		if(first){
			initHandlers();
			first = false;
		}
		update.Util.getInstance().getRaumInfoByLatLng(context.getLatitude(), context.getLongitude(), niveau, new AsyncCallback<Raum>() {
			@Override
			public void onSuccess(Raum result) {
				raum = result;
				if(null != raum.name){
					exists = true;
					txtName.setText(raum.name);
					lbTyp.setSelectedIndex(raum.typ);
					update.Util.getInstance().getPersonbyRID(raum.id, new AsyncCallback<Person[]>() {
						
						@Override
						public void onSuccess(Person[] result) {
							
							gridPersonen=new Grid(result.length+1, 4);
							gridPersonen.setWidget(0, 0, btnSuchen);
							gridPersonen.setWidget(0, 1, txtVorname);
							gridPersonen.setWidget(0, 2, txtNachname);
							gridPersonen.setWidget(0, 3, txtTitel);
							
							for(int i = 1;i<result.length+1;i++){
								Button delPerson = new Button("-");
								delPerson.setTitle(""+result[i].id);
								gridPersonen.setWidget(i, 0, delPerson);
								gridPersonen.setText(i, 1, result[i].vorname);
								gridPersonen.setText(i, 2, result[i].nachname);
								gridPersonen.setText(i, 3, result[i].titel);
							}
						}
						
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						
					});
				} else {
					
					gridPersonen = new Grid(1,4);
					gridPersonen.setWidget(0, 0, btnSuchen);
					gridPersonen.setWidget(0, 1, txtVorname);
					gridPersonen.setWidget(0, 2, txtNachname);
					gridPersonen.setWidget(0, 3, txtTitel);
					//lol
				}
				panel.add(gridPersonen);
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});

		lbTyp = new ListBox();
		lbTyp.addItem("Buero");
		lbTyp.addItem("Hoersaal");
		lbTyp.addItem("Seminarraum");
		lbTyp.setVisibleItemCount(1);
		
		grid = new Grid(3,2);
		grid.setWidget(0, 0, btnSpeichern);
		grid.setWidget(0, 1, btnAbbrechen);
		
		grid.setWidget(1, 0, lblName);
		grid.setWidget(1, 1, txtName);
		
		grid.setWidget(2, 0, lblTyp);
		grid.setWidget(2, 1, lbTyp);

		panel = new VerticalPanel();

		txtVorname.setText("Vorname");
		txtNachname.setText("Nachname");
		txtTitel.setText("Titel");

		panel.add(grid);
		panel.setSize("300px", "300px");
		initWidget(panel);
	}
	void initHandlers(){
		btnSuchen.addClickHandler(chs);
		btnPlus.addClickHandler(chp);
		btnClear.addClickHandler(chc);
	}
}
