package events;

import calc.noSwing.ActionEvent;

public class ClrActionEvent extends ActionEvent {
	public ClrActionEvent(Object obj, int id, String message) {
		super(obj, id, message);
	}

	public String getActionCommand() {
		return msg;
	}
}
