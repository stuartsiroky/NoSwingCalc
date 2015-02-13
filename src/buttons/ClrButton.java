package buttons;

import calc.noSwing.ActionListener;
import calc.noSwing.JButton;
import events.ClrActionEvent;

public class ClrButton extends JButton {

	public ClrButton(String string) {
		super(string);
	}

	public void addActionListener(ActionListener handler) {
		System.out.println("ClrButton.addActionListener(ActionListener handler)");
		hdlr = handler;
	}

	public void pushed() {
		System.out.println("Clr pushed");
		ClrActionEvent e = new ClrActionEvent(this, 1, str);
		hdlr.actionPerformed(e);
	}
}
