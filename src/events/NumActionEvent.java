package events;

import calc.noSwing.ActionEvent;

public class NumActionEvent extends ActionEvent {
	public NumActionEvent(Object obj, int id, String message) {
		super(obj, id, message);
	}

	public String getActionCommand() {
		return msg;
	}
}
