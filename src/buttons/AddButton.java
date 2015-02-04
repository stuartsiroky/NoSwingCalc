package buttons;

import calc.noSwing.ActionListener;
import calc.noSwing.JButton;
import events.AddActionEvent;

public class AddButton extends JButton {

	public AddButton(String string, ActionListener handler) {
		super(string);
		hdlr = handler;
	}

	public void addActionListener(ActionListener handler) {
		hdlr = handler;
	}

	public void pushed() {
		System.out.println("+ pushed");
		AddActionEvent e = new AddActionEvent(this, 1, str);
		hdlr.actionPerformed(e);
	}
}
