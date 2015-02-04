package events;

import calc.model.ModelEvent;

public class StoreModelEvent extends ModelEvent {

	public StoreModelEvent(Object obj, int id, String message, int amount) {
		super(obj, id, message, amount);
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String getActionCommand() {
		// TODO Auto-generated method stub
		return null;
	}
}
