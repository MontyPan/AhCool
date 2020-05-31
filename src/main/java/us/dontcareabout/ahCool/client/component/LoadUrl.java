package us.dontcareabout.ahCool.client.component;

import com.google.gwt.event.shared.HandlerRegistration;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.sencha.gxt.widget.core.client.form.TextField;

public 	class LoadUrl extends HorizontalLayoutContainer {
	private static final HorizontalLayoutData flHLD = new HorizontalLayoutData(1, 1);
	private static final HorizontalLayoutData btnHLD = new HorizontalLayoutData(70, 1, new Margins(5));

	private FieldLabel fl = new FieldLabel();
	private TextButton loadBtn = new TextButton("載入");
	private TextField urlField = new TextField();

	public LoadUrl() {
		fl.setWidget(urlField);
		fl.setLabelAlign(LabelAlign.TOP);
		add(fl, flHLD);
		add(loadBtn, btnHLD);
	}

	public void setLabel(String label) {
		fl.setText(label);
	}

	public String getUrl() {
		return urlField.getCurrentValue();
	}

	public void setUrl(String url) {
		urlField.setValue(url);
	}

	public HandlerRegistration addLoadHandler(SelectHandler handler) {
		return loadBtn.addSelectHandler(handler);
	}
}