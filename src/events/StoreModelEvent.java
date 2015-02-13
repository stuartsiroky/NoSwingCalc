package events;

import calc.model.ModelEvent;

public class StoreModelEvent extends ModelEvent {

	public StoreModelEvent(Object obj, int id, String message, int amount) {
		super(obj, id, message, amount);
//		System.out.println("StoreModelEvent.StoreModelEvent(Object obj, int id, String message, int amount)");
	}

	public int getAmount() {
		System.out.println("StoreModelEvent.getAmount()");
		return amount;
	}

	@Override
	public String getActionCommand() {
		System.out.println("StoreModelEvent.getActionCommand()");
		return null;
	}
}
