package events;

import calc.model.ModelEvent;

public class EqualsModelEvent extends ModelEvent {

	public EqualsModelEvent(Object obj, int id, String message, int amount) {
		super(obj, id, message, amount);
//		System.out.println("EqualsModelEvent.EqualsModelEvent(Object obj, int id, String message, int amount)");
	}

	public int getAmount() {
		System.out.println("EqualsModelEvent.getAmount()");
		return amount;
	}

	@Override
	public String getActionCommand() {
		System.out.println("EqualsModelEvent.getActionCommand()");
		return null;
	}

}
