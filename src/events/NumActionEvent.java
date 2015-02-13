package events;

import calc.noSwing.ActionEvent;

public class NumActionEvent extends ActionEvent {
	public NumActionEvent(Object obj, int id, String message) {
		super(obj, id, message);
//		System.out.println("NumActionEvent.NumActionEvent(Object obj, int id, String message)");
	}

	public String getActionCommand() {
		System.out.println("NumActionEvent.getActionCommand()");
		return msg;
	}
}
