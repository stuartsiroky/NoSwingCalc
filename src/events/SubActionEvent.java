package events;

import calc.noSwing.ActionEvent;

public class SubActionEvent extends ActionEvent {
	public SubActionEvent(Object obj, int id, String message) {
		super(obj, id, message);
//		System.out.println("SubActionEvent.SubActionEvent(Object obj, int id, String message)");
	}

	public String getActionCommand() {
		System.out.println("SubActionEvent.getActionCommand()");
		return msg;
	}
}
