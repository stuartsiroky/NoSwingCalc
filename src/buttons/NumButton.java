package buttons;

import calc.noSwing.ActionListener;
import calc.noSwing.JButton;
import events.NumActionEvent;

public class NumButton extends JButton {

	public NumButton(String string, ActionListener handler) {
		super(string);
		hdlr = handler;
	}

	public void addActionListener(ActionListener handler) {
		hdlr = handler;
	}

	public void pushed() {
		System.out.println(str + " pushed");
		NumActionEvent e = new NumActionEvent(this, 1, str);
		hdlr.actionPerformed(e);
	}
}
