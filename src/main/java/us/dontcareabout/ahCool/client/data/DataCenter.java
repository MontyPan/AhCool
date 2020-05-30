package us.dontcareabout.ahCool.client.data;

import java.util.ArrayList;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

import us.dontcareabout.ahCool.client.data.BasicDataReadyEvent.BasicDataReadyHandler;
import us.dontcareabout.gwt.client.google.Sheet;
import us.dontcareabout.gwt.client.google.SheetHappen;
import us.dontcareabout.gwt.client.google.SheetHappen.Callback;

public class DataCenter {
	private final static SimpleEventBus eventBus = new SimpleEventBus();

	public static ArrayList<BasicData> basicDataList;

	public static void wantBasicData(String sheetId) {
		basicDataList = new ArrayList<>();
		SheetHappen.get(sheetId, new Callback<BasicData>() {
			@Override
			public void onSuccess(Sheet<BasicData> gs) {
				basicDataList = gs.getEntry();
				eventBus.fireEvent(new BasicDataReadyEvent());
			}

			@Override
			public void onError(Throwable exception) {}
		});
	}

	public static HandlerRegistration addBasicDataReady(BasicDataReadyHandler handler) {
		return eventBus.addHandler(BasicDataReadyEvent.TYPE, handler);
	}
}
