package us.dontcareabout.ahCool.client.component;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;

import us.dontcareabout.ahCool.client.data.Result;
import us.dontcareabout.gxt.client.component.Grid2;
import us.dontcareabout.gxt.client.model.GetValueProvider;

public class ResultGrid extends Grid2<Result> {
	private static final Properties properties = GWT.create(Properties.class);

	public ResultGrid() {
		init();
	}

	@Override
	protected ListStore<Result> genListStore() {
		return new ListStore<Result>(new ModelKeyProvider<Result>() {
			@Override
			public String getKey(Result item) {
				return item.basic.getIndex() + ":" + item.input.getIndex();
			}
		});
	}

	@Override
	protected ColumnModel<Result> genColumnModel() {
		List<ColumnConfig<Result, ?>> result = new ArrayList<>();

		result.add(new ColumnConfig<>(new GetValueProvider<Result, Integer>() {
			@Override
			public Integer getValue(Result object) {
				return object.basic.getIndex();
			}
		}, 40, "分析"));
		result.add(new ColumnConfig<>(new GetValueProvider<Result, Integer>() {
			@Override
			public Integer getValue(Result object) {
				return object.input.getIndex();
			}
		}, 40, "輸入"));

		result.add(new ColumnConfig<>(properties.area(), 60, "行政區"));
		result.add(new ColumnConfig<>(properties.section(), 40, "段"));
		result.add(new ColumnConfig<>(properties.block(), 40, "小段"));
		result.add(new ColumnConfig<>(properties.number(), 90, "地號"));
		result.add(new ColumnConfig<>(properties.originArea(), 100, "原始面積"));
		result.add(new ColumnConfig<>(properties.agreeArea(), 100, "協議價購面積"));
		result.add(new ColumnConfig<>(properties.numerator(), 60, "分子"));
		result.add(new ColumnConfig<>(properties.denominator(), 60, "分母"));
		result.add(new ColumnConfig<>(properties.agreePrice(), 100, "協議價購單價"));
		result.add(new ColumnConfig<>(new GetValueProvider<Result, String>() {
			@Override
			public String getValue(Result object) {
				return NumberFormat.getFormat("#####").format(object.getRealPrice());
			}
		}, 100, "協議價購總額"));
		return new ColumnModel<>(result);
	}

	interface Properties extends PropertyAccess<Result> {
		ValueProvider<Result, String> area();
		ValueProvider<Result, String> section();
		ValueProvider<Result, String> block();
		ValueProvider<Result, String> number();
		ValueProvider<Result, Integer> originArea();
		ValueProvider<Result, Integer> agreeArea();
		ValueProvider<Result, Integer> agreePrice();
		ValueProvider<Result, Integer> declarePrice();

		ValueProvider<Result, Integer> numerator();
		ValueProvider<Result, Integer> denominator();

		ValueProvider<Result, String> type();
		ValueProvider<Result, String> useType();
		ValueProvider<Result, String> refactorFarm();
		ValueProvider<Result, String> note();
		ValueProvider<Result, String> comment();

	}
}
