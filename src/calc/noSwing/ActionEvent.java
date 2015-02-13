package calc.noSwing;

public abstract class ActionEvent {
	protected String msg;

	public ActionEvent(Object obj, int id, String message) {
//		System.out.println("ActionEvent.ActionEvent(Object obj, int id, String message)");
		msg = message;
	}

	public abstract String getActionCommand();

}
