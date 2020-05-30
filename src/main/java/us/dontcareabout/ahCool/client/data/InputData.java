package us.dontcareabout.ahCool.client.data;

import com.google.common.base.Strings;

import us.dontcareabout.gwt.client.google.SheetEntry;

public final class InputData extends SheetEntry {
	protected InputData() {}

	public String getArea() {
		return stringField("鄉鎮市區");
	}

	public String getSection() {
		return stringField("段");
	}

	public String getBlock() {
		return stringField("小段");
	}

	public String getNumber() {
		return stringField("地號");
	}

	public int getNumerator() {
		return groupIntField("分子");
	}

	public int getDenominator() {
		return groupIntField("分母");
	}

	//Refactory 移去 GST？
	private int groupIntField(String name) {
		String value = stringField(name);
		if (Strings.isNullOrEmpty(value)) { return 0; }
		return Integer.valueOf(value.replace(",", ""));
	}
}
