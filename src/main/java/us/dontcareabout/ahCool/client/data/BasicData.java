package us.dontcareabout.ahCool.client.data;

import com.google.common.base.Strings;

import us.dontcareabout.gwt.client.google.SheetEntry;

public final class BasicData extends SheetEntry {
	protected BasicData() {}

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

	public String getType() {
		return stringField("分區");
	}

	public String getUseType() {
		return stringField("使用地類別");
	}

	public String getRefactorFarm() {
		return stringField("農地重劃");
	}

	public int getOriginArea() {
		return groupIntField("原始面積");
	}

	public int getAgreeArea() {
		return groupIntField("協議價購面積");
	}

	public int getAgreePrice() {
		return groupIntField("協議價購單價");
	}

	public int getDeclarePrice() {
		return groupIntField("公告現值");
	}

	public String getNote() {
		return stringField("註記");
	}

	public String getComment() {
		return stringField("備註");
	}

	//Refactory 移去 GST？
	private int groupIntField(String name) {
		String value = stringField(name);
		if (Strings.isNullOrEmpty(value)) { return 0; }
		return Integer.valueOf(value.replace(",", ""));
	}
}
