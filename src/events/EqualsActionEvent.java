package events;

import calc.noSwing.ActionEvent;

public class EqualsActionEvent extends ActionEvent {
	public EqualsActionEvent(Object obj, int id, String message) {
		super(obj, id, message);
//		System.out.println("EqualsActionEvent.EqualsActionEvent(Object obj, int id, String message)");
	}

	public String getActionCommand() {
		System.out.println("EqualsActionEvent.getActionCommand()");
		return msg;
	}
}
