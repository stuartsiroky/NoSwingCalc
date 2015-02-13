package buttons;

import calc.noSwing.ActionListener;
import calc.noSwing.JButton;
import events.AddActionEvent;

public class AddButton extends JButton {

	public AddButton(String string) {
		super(string);
	}

	public void addActionListener(ActionListener handler) {
		System.out.println("AddButton.addActionListener(ActionListener handler)");
		hdlr = handler;
	}

	public void pushed() {
		System.out.println("+ pushed");
		AddActionEvent e = new AddActionEvent(this, 1, str);
		hdlr.actionPerformed(e);
	}
}
