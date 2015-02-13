package events;

import calc.noSwing.ActionEvent;

public class AddActionEvent extends ActionEvent {
	public AddActionEvent(Object obj, int id, String message) {
		super(obj, id, message);
//		System.out.println("AddActionEvent.AddActionEvent(Object obj, int id, String message)");
	}

	public String getActionCommand() {
		System.out.println("AddActionEvent.getActionCommand()");
		return msg;
	}
}
