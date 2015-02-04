package buttons;

import calc.noSwing.ActionListener;
import calc.noSwing.JButton;
import events.ClrActionEvent;

public class ClrButton extends JButton {

	public ClrButton(String string, ActionListener handler) {
		super(string);
		hdlr = handler;
	}

	public void addActionListener(ActionListener handler) {
		hdlr = handler;
	}

	public void pushed() {
		System.out.println("Clr pushed");
		ClrActionEvent e = new ClrActionEvent(this, 1, str);
		hdlr.actionPerformed(e);
	}
}
