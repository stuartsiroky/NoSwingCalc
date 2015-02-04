package buttons;

import calc.noSwing.ActionListener;
import calc.noSwing.JButton;
import events.EqualsActionEvent;

public class EqualsButton extends JButton {

	public EqualsButton(String string, ActionListener handler) {
		super(string);
		hdlr = handler;
	}

	public void addActionListener(ActionListener handler) {
		hdlr = handler;
	}

	public void pushed() {
		System.out.println("= pushed");
		EqualsActionEvent e = new EqualsActionEvent(this, 1, str);
		hdlr.actionPerformed(e);
	}
}
