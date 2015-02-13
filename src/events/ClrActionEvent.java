package events;

import calc.noSwing.ActionEvent;

public class ClrActionEvent extends ActionEvent {
	public ClrActionEvent(Object obj, int id, String message) {
		super(obj, id, message);
//		System.out.println("ClrActionEvent.ClrActionEvent(Object obj, int id, String message)");
	}

	public String getActionCommand() {
		System.out.println("ClrActionEvent.getActionCommand()");
		return msg;
	}
}
