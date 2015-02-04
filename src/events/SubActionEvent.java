package events;

import calc.noSwing.ActionEvent;

public class SubActionEvent extends ActionEvent {
	public SubActionEvent(Object obj, int id, String message) {
		super(obj, id, message);
	}

	public String getActionCommand() {
		return msg;
	}
}
