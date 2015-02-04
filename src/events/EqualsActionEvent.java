package events;

import calc.noSwing.ActionEvent;

public class EqualsActionEvent extends ActionEvent {
	public EqualsActionEvent(Object obj, int id, String message) {
		super(obj, id, message);
	}

	public String getActionCommand() {
		return msg;
	}
}
