package calc.view;

import buttons.AddButton;
import buttons.ClrButton;
import buttons.EqualsButton;
import buttons.NumButton;
import buttons.SubButton;
import calc.controller.CalculatorController;
import calc.model.CalculatorModel;
import calc.model.ModelEvent;
import calc.noSwing.ActionEvent;
import calc.noSwing.ActionListener;
import calc.noSwing.BorderLayout;
import calc.noSwing.GridLayout;
import calc.noSwing.JPanel;
import calc.noSwing.JTextField;

public class CalculatorView extends JFrameView {
	public static final String PLUS = "+";
	public static final String MINUS = "-";
	public static final String CLEAR = "Clr";
	public static final String EQUALS = "=";

	// public static int fake_state = 0;
	private JTextField textField = new JTextField();

	public NumHandler numhandler = new NumHandler();
	public ClrHandler clrhandler = new ClrHandler();
	public AddHandler addhandler = new AddHandler();
	public SubHandler subhandler = new SubHandler();
	public EqHandler eqhandler = new EqHandler();
	public NumButton jButton1 = new NumButton("1", numhandler);
	public NumButton jButton2 = new NumButton("2", numhandler);
	public NumButton jButton3 = new NumButton("3", numhandler);
	public NumButton jButton4 = new NumButton("4", numhandler);
	public NumButton jButton5 = new NumButton("5", numhandler);
	public NumButton jButton6 = new NumButton("6", numhandler);
	public NumButton jButton7 = new NumButton("7", numhandler);
	public NumButton jButton8 = new NumButton("8", numhandler);
	public NumButton jButton9 = new NumButton("9", numhandler);
	public NumButton jButton0 = new NumButton("0", numhandler);
	public SubButton minusButton = new SubButton(MINUS, subhandler);
	public AddButton plusButton = new AddButton(PLUS, addhandler);
	public ClrButton clearButton = new ClrButton(CLEAR, clrhandler);
	public EqualsButton equalsButton = new EqualsButton(EQUALS, eqhandler);

	public CalculatorView(CalculatorModel model, CalculatorController controller) {
		super(model, controller);

		textField.setText("0");
		this.getContentPane().add(textField, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
		this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.add(jButton1, null);
		buttonPanel.add(jButton2, null);
		buttonPanel.add(jButton3, null);
		buttonPanel.add(jButton4, null);
		buttonPanel.add(jButton5, null);
		buttonPanel.add(jButton6, null);
		buttonPanel.add(jButton7, null);
		buttonPanel.add(jButton8, null);
		buttonPanel.add(jButton9, null);
		buttonPanel.add(jButton0, null);
		buttonPanel.add(minusButton, null);
		buttonPanel.add(plusButton, null);
		buttonPanel.add(clearButton, null);
		buttonPanel.add(equalsButton, null);
		pack();

	}

	// Now implement the necessary event handling code
	public void modelChanged(ModelEvent event) {
		String msg = event.getAmount() + "";
		textField.setText(msg);
		System.out.println("\t" + msg);
	}

	// Inner classes for Event Handling
	public abstract class Handler implements ActionListener {
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			// CalculatorController c = (CalculatorController) getController();
			// String ae = e.getActionCommand();
			// c.numOperation(ae);
		}
	}

	// Inner classes for Event Handling
	public class EqHandler extends Handler {
		public void actionPerformed(ActionEvent e) {
			CalculatorController c = (CalculatorController) getController();
			c.equalsOperation();
		}

	}

	// Inner classes for Event Handling
	public class AddHandler extends Handler {
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			CalculatorController c = (CalculatorController) getController();
			c.addOperation();
		}
	}

	// Inner classes for Event Handling
	public class SubHandler extends Handler {
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			CalculatorController c = (CalculatorController) getController();
			c.subOperation();
		}
	}

	// Inner classes for Event Handling
	public class ClrHandler extends Handler {
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			CalculatorController c = (CalculatorController) getController();
			c.clrOperation();
		}
	}

	// Inner classes for Event Handling
	public class NumHandler extends Handler {
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			CalculatorController c = (CalculatorController) getController();
			String ae = e.getActionCommand();
			c.numOperation(ae);
		}
	}

	public static void main(String[] args) {
		int a = 1;
		int b = 3;

		CalculatorController cc = new CalculatorController();
		CalculatorView cv = (CalculatorView) cc.getView();

		start(cv, a, b);
	}

	static void start(CalculatorView calc, int a, int b) {
		if (a > b) {
			// fake_state = 0;
			addition(calc, a, b);
		} else if (a < b) {
			// fake_state = 0;
			subtraction(calc, b, a);
		}
		// else {
		// fake_state = 1;
		// EqualsActionEvent e = new EqualsActionEvent(calc, 101, "101");
		// calc.handler.actionPerformed(e);
		// }
		equalsMethod(calc);

	}

	static void addition(CalculatorView calc, int a, int b) {
		pickButton(calc, a);
		calc.plusButton.pushed();
		pickButton(calc, b);
	}

	static void subtraction(CalculatorView calc, int a, int b) {
		pickButton(calc, b);
		calc.minusButton.pushed();
		pickButton(calc, a);
	}

	static void equalsMethod(CalculatorView calc) {
		calc.equalsButton.pushed();
	}

	static void pickButton(CalculatorView calc, int val) {
		switch (val) {
		case 0:
			calc.jButton0.pushed();
			break;
		case 1:
			calc.jButton1.pushed();
			break;
		case 2:
			calc.jButton2.pushed();
			break;
		case 3:
			calc.jButton3.pushed();
			break;
		case 4:
			calc.jButton4.pushed();
			break;
		case 5:
			calc.jButton5.pushed();
			break;
		case 6:
			calc.jButton6.pushed();
			break;
		case 7:
			calc.jButton7.pushed();
			break;
		case 8:
			calc.jButton8.pushed();
			break;
		case 9:
			calc.jButton9.pushed();
			break;
		}
	}

}
