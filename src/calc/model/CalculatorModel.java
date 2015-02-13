package calc.model;

import events.EqualsModelEvent;
import events.StoreModelEvent;

public class CalculatorModel extends AbstractModel {
	private int total = 0;
	private int current = 0;
	private String state = "add";

	public void clear() {
		System.out.println("CalculatorModel.clear()");
		total = 0;
		store(0);
	}

	public void store(int value) {
		System.out.println("CalculatorModel.store(int value)");
		current = value;
		StoreModelEvent me = new StoreModelEvent(this, 1, "", current);
		notifyChanged(me);
	}

//	public void notifyChanged(ModelEvent event) {
//		super.notifyChanged(event);
//		System.out.println(".");
//	}

	public void add() {
		System.out.println("CalculatorModel.add()");
		state = "add";
		total = current;
	}

	public void subtract() {
		System.out.println("CalculatorModel.subtract()");
		state = "subtract";
		total = current;
	}

	public void equalsOp() {
		System.out.println("CalculatorModel.equalsOp()");
		if (state == "add") {
			total += current;
		} else {
			total -= current;
		}
		current = total;
		EqualsModelEvent me = new EqualsModelEvent(this, 1, "", total);
		notifyChanged(me);
	}

	public int getTotal() {
		System.out.println("CalculatorModel.getTotal()");
		return total;
	}
}
