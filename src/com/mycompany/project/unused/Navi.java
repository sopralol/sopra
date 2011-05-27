package com.mycompany.project.unused;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class Navi extends Composite {

	public Navi() {
		
		Grid grid = new Grid(2, 1);
		initWidget(grid);
		grid.setSize("107px", "201px");
		
		Grid grid_1 = new Grid(3, 3);
		grid.setWidget(0, 0, grid_1);
		
		Button button = new Button("N");
		grid_1.setWidget(0, 1, button);
		button.setPixelSize(30,30);
		Button button2 = new Button("W");
		grid_1.setWidget(1, 0, button2);
		button2.setPixelSize(30,30);
		
		Button button_4 = new Button("New button");
		button_4.setText("C");
		grid_1.setWidget(1, 1, button_4);
		button_4.setSize("30", "30");
		Button button3 = new Button("S");
		grid_1.setWidget(2, 1, button3);
		button3.setPixelSize(30,30);
		Button button4 = new Button("O");
		grid_1.setWidget(1, 2, button4);
		button4.setPixelSize(30,30);
		
		
		
		
		Grid grid_2 = new Grid(3, 1);
		grid.setWidget(1, 0, grid_2);
		
		Button button_1 = new Button("New button");
		button_1.setText("+");
		grid_2.setWidget(0, 0, button_1);
		button_1.setWidth("20");
		
		Button button_2 = new Button("New button");
		button_2.setText("0");
		grid_2.setWidget(1, 0, button_2);
		button_2.setWidth("20");
		
		Button button_3 = new Button("New button");
		button_3.setText("-");
		grid_2.setWidget(2, 0, button_3);
		button_3.setWidth("20");
		grid_2.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		grid_2.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid_2.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
		grid_2.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid_2.getCellFormatter().setVerticalAlignment(2, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid_2.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);
		grid.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
		grid.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_MIDDLE);
	}
}
