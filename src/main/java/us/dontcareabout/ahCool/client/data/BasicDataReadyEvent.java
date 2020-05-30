package us.dontcareabout.ahCool.client.data;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import us.dontcareabout.ahCool.client.data.BasicDataReadyEvent.BasicDataReadyHandler;

public class BasicDataReadyEvent extends GwtEvent<BasicDataReadyHandler> {
	public static final Type<BasicDataReadyHandler> TYPE = new Type<BasicDataReadyHandler>();

	@Override
	public Type<BasicDataReadyHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(BasicDataReadyHandler handler) {
		handler.onBasicDataReady(this);
	}

	public interface BasicDataReadyHandler extends EventHandler{
		public void onBasicDataReady(BasicDataReadyEvent event);
	}
}
