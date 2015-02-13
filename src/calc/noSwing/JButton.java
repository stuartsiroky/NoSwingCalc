package calc.noSwing;

public abstract class JButton {
	protected String str;
	protected ActionListener hdlr;

	public JButton(String string) {
//		System.out.println("JButton.JButton(String string)");
		str = string;
	}

	public abstract void addActionListener(ActionListener handler);

	public abstract void pushed();

}
