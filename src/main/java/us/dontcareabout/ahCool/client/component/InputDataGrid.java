package us.dontcareabout.ahCool.client.component;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;

import us.dontcareabout.ahCool.client.data.InputData;
import us.dontcareabout.gxt.client.component.Grid2;

public class InputDataGrid extends Grid2<InputData> {
	private static final Properties properties = GWT.create(Properties.class);

	public InputDataGrid() {
		init();
	}

	@Override
	protected ListStore<InputData> genListStore() {
		return new ListStore<InputData>(properties.key());
	}

	@Override
	protected ColumnModel<InputData> genColumnModel() {
		List<ColumnConfig<InputData, ?>> result = new ArrayList<>();
		result.add(new ColumnConfig<>(properties.area(), 60, "行政區"));
		result.add(new ColumnConfig<>(properties.section(), 40, "段"));
		result.add(new ColumnConfig<>(properties.block(), 40, "小段"));
		result.add(new ColumnConfig<>(properties.number(), 90, "地號"));
		result.add(new ColumnConfig<>(properties.numerator(), 60, "分子"));
		result.add(new ColumnConfig<>(properties.denominator(), 60, "分母"));
		return new ColumnModel<>(result);
	}

	interface Properties extends PropertyAccess<InputData> {
		@Path("index") ModelKeyProvider<InputData> key();
		ValueProvider<InputData, String> area();
		ValueProvider<InputData, String> section();
		ValueProvider<InputData, String> block();
		ValueProvider<InputData, String> number();
		ValueProvider<InputData, Integer> numerator();
		ValueProvider<InputData, Integer> denominator();
	}
}
