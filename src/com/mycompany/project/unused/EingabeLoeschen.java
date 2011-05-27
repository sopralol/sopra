/*package com.mycompany.project.unused;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class EingabeLoeschen extends PopupPanel {

	public EingabeLoeschen() {
		super(true);
		
		Grid grid = new Grid(3, 1);
		setWidget(grid);
		grid.setSize("100%", "100%");
		
		Grid grid_1 = new Grid(1, 5);
		grid.setWidget(0, 0, grid_1);
		
		Label lblRaumnummer = new Label("Raumnummer");
		grid_1.setWidget(0, 0, lblRaumnummer);
		
		TextBox textBox = new TextBox();
		grid_1.setWidget(0, 1, textBox);
		
		Label lblGebudekreuz = new Label("Geb\u00E4udekreuz");
		grid_1.setWidget(0, 2, lblGebudekreuz);
		
		TextBox textBox_1 = new TextBox();
		grid_1.setWidget(0, 3, textBox_1);
		
		Button button = new Button("New button");
		button.setText("Hinzuf\u00FCgen");
		grid_1.setWidget(0, 4, button);
		
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(true);
		grid.setWidget(1, 0, scrollPanel);
		
		Grid grid_2 = new Grid(3, 1);
		scrollPanel.setWidget(grid_2);
		grid_2.setSize("100%", "100%");
		
		Label lblRaumGebudekreuz = new Label("Raum: 2001 Geb\u00E4udekreuz: O27");
		grid_2.setWidget(0, 0, lblRaumGebudekreuz);
		
		Label lblRaumGebudekreuz_1 = new Label("Raum: 2001 Geb\u00E4udekreuz: O7");
		grid_2.setWidget(1, 0, lblRaumGebudekreuz_1);
		
		Label lblRaumGebudekreuz_2 = new Label("Raum: 201 Geb\u00E4udekreuz: O27");
		grid_2.setWidget(2, 0, lblRaumGebudekreuz_2);
		
		FlowPanel flowPanel = new FlowPanel();
		grid.setWidget(2, 0, flowPanel);
		
		Button button_2 = new Button("New button");
		button_2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			EingabeLoeschen.this.setVisible(false);
			new Loeschen().center();
			}
		});
		button_2.setText("R\u00E4ume auf Karte anzeigen");
		flowPanel.add(button_2);
		
		Button button_1 = new Button("New button");
		button_1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			EingabeLoeschen.this.setVisible(false);
			}
		});
		button_1.setText("L\u00F6schen");
		flowPanel.add(button_1);
		grid.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		
	}

}
*/