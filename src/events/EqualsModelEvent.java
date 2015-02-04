package events;

import calc.model.ModelEvent;

public class EqualsModelEvent extends ModelEvent {

	public EqualsModelEvent(Object obj, int id, String message, int amount) {
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
