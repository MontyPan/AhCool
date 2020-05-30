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
import com.sencha.gxt.widget.core.client.grid.GridView;

import us.dontcareabout.ahCool.client.data.BasicData;
import us.dontcareabout.gxt.client.component.Grid2;

public class BasicDataGrid extends Grid2<BasicData> {
	private static final Properties properties = GWT.create(Properties.class);

	public BasicDataGrid() {
		init();
	}

	@Override
	protected ListStore<BasicData> genListStore() {
		return new ListStore<BasicData>(properties.key());
	}

	@Override
	protected ColumnModel<BasicData> genColumnModel() {
		List<ColumnConfig<BasicData, ?>> result = new ArrayList<>();
		result.add(new ColumnConfig<>(properties.area(), 7, "行政區"));
		result.add(new ColumnConfig<>(properties.section(), 5, "段"));
		result.add(new ColumnConfig<>(properties.block(), 5, "小段"));
		result.add(new ColumnConfig<>(properties.number(), 10, "地號"));
		result.add(new ColumnConfig<>(properties.type(), 7, "分區"));
		result.add(new ColumnConfig<>(properties.useType(), 7, "使用地類別"));
		result.add(new ColumnConfig<>(properties.refactorFarm(), 7, "農地重劃"));
		result.add(new ColumnConfig<>(properties.originArea(), 10, "原始面積"));
		result.add(new ColumnConfig<>(properties.agreePrice(), 10, "協議價購面積"));
		result.add(new ColumnConfig<>(properties.agreeArea(), 10, "協議價購單價"));
		result.add(new ColumnConfig<>(properties.declarePrice(), 10, "公告現值"));
		result.add(new ColumnConfig<>(properties.note(), 10, "註記"));
		result.add(new ColumnConfig<>(properties.comment(), 10, "備註"));
		return new ColumnModel<>(result);
	}

	@Override
	protected GridView<BasicData> genGridView() {
		GridView<BasicData> result = new GridView<>();
		result.setForceFit(true);
		return result;
	}



	interface Properties extends PropertyAccess<BasicData> {
		@Path("index") ModelKeyProvider<BasicData> key();
		ValueProvider<BasicData, String> area();
		ValueProvider<BasicData, String> section();
		ValueProvider<BasicData, String> block();
		ValueProvider<BasicData, String> number();
		ValueProvider<BasicData, String> type();
		ValueProvider<BasicData, String> useType();
		ValueProvider<BasicData, String> refactorFarm();
		ValueProvider<BasicData, Integer> originArea();
		ValueProvider<BasicData, Integer> agreeArea();
		ValueProvider<BasicData, Integer> agreePrice();
		ValueProvider<BasicData, Integer> declarePrice();
		ValueProvider<BasicData, String> note();
		ValueProvider<BasicData, String> comment();
	}
}
