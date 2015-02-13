package buttons;

import calc.noSwing.ActionListener;
import calc.noSwing.JButton;
import events.NumActionEvent;

public class NumButton extends JButton {

	public NumButton(String string) {
		super(string);
	}

	public void addActionListener(ActionListener handler) {
		System.out.println("NumButton.addActionListener(ActionListener handler)");
		hdlr = handler;
	}

	public void pushed() {
		System.out.println(str + " pushed");
		NumActionEvent e = new NumActionEvent(this, 1, str);
		hdlr.actionPerformed(e);
	}
}
