package com.mycompany.project.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Kartendaten extends PopupPanel {

	static TextBox txtUrl;

	public Kartendaten() {
		super();
		HorizontalPanel panel = new HorizontalPanel();
		Button btnSave = new Button("Speichern");
		Button btnCancel = new Button("Abbrechen");
		txtUrl = new TextBox();
		txtUrl.setValue(Auswahl.urlstring);
		btnCancel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		btnSave.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Auswahl.urlstring = txtUrl.getValue();
				update.Util.getInstance().mach_url(txtUrl.getValue(), new AsyncCallback<Void>() {
					
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
		
		panel.add(txtUrl);
		panel.add(btnSave);
		panel.add(btnCancel);
		
		setWidget(panel);
		
	}
	protected void onDetach() {
		super.onDetach();
		Window.Location.reload();
	}
}
