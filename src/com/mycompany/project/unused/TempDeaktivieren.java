package com.mycompany.project.unused;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class TempDeaktivieren extends PopupPanel {

	public TempDeaktivieren() {
		super(true);
		
		Grid grid = new Grid(2, 4);
		setWidget(grid);
		grid.setSize("200px", "238px");
		
		Label lblStart = new Label("Start");
		grid.setWidget(0, 0, lblStart);
		
		DatePicker datePicker = new DatePicker();
		grid.setWidget(0, 1, datePicker);
		
		Label lblEnde = new Label("Ende");
		grid.setWidget(0, 2, lblEnde);
		
		DatePicker datePicker_1 = new DatePicker();
		grid.setWidget(0, 3, datePicker_1);
		grid.getCellFormatter().setHorizontalAlignment(1, 3, HasHorizontalAlignment.ALIGN_RIGHT);
		
		Button button = new Button("New button");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TempDeaktivieren.this.setVisible(false);
				
			}
		});
		button.setText("Fertig");
		grid.setWidget(1, 3, button);
	}

}
