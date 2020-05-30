package us.dontcareabout.ahCool.client.data;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import us.dontcareabout.ahCool.client.data.InputDataReadyEvent.InputDataReadyHandler;

public class InputDataReadyEvent extends GwtEvent<InputDataReadyHandler> {
	public static final Type<InputDataReadyHandler> TYPE = new Type<InputDataReadyHandler>();

	@Override
	public Type<InputDataReadyHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(InputDataReadyHandler handler) {
		handler.onInputDataReady(this);
	}

	public interface InputDataReadyHandler extends EventHandler{
		public void onInputDataReady(InputDataReadyEvent event);
	}
}
