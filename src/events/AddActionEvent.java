package events;

import calc.noSwing.ActionEvent;

public class AddActionEvent extends ActionEvent {
	public AddActionEvent(Object obj, int id, String message) {
		super(obj, id, message);
	}

	public String getActionCommand() {
		return msg;
	}
}
