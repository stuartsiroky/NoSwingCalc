package buttons;

import calc.noSwing.ActionListener;
import calc.noSwing.JButton;
import events.SubActionEvent;

public class SubButton extends JButton {

	public SubButton(String string) {
		super(string);
	}

	public void addActionListener(ActionListener handler) {
		System.out.println("SubButton.addActionListener(ActionListener handler)");
		hdlr = handler;
	}

	public void pushed() {
		System.out.println("- pushed");
		SubActionEvent e = new SubActionEvent(this, 1, str);
		hdlr.actionPerformed(e);
	}
}
