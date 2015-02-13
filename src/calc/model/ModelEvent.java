package calc.model;

import calc.noSwing.ActionEvent;

public abstract class ModelEvent extends ActionEvent {
	protected int amount;

	public ModelEvent(Object obj, int id, String message, int amount) {
		super(obj, id, message);
//		System.out.println("ModelEvent.ModelEvent(Object obj, int id, String message, int amount)");
		this.amount = amount;
	}

	public abstract int getAmount();

}
