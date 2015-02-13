package calc.view;

import linkedListPkg.RunnableLinkedList;
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

	private JTextField textField = new JTextField();

	public NumHandler numhandler = new NumHandler();
	public ClrHandler clrhandler = new ClrHandler();
	public AddHandler addhandler = new AddHandler();
	public SubHandler subhandler = new SubHandler();
	public EqHandler eqhandler = new EqHandler();
	public NumButton jButton1 = new NumButton("1");
	public NumButton jButton2 = new NumButton("2");
	public NumButton jButton3 = new NumButton("3");
	public NumButton jButton4 = new NumButton("4");
	public NumButton jButton5 = new NumButton("5");
	public NumButton jButton6 = new NumButton("6");
	public NumButton jButton7 = new NumButton("7");
	public NumButton jButton8 = new NumButton("8");
	public NumButton jButton9 = new NumButton("9");
	public NumButton jButton0 = new NumButton("0");
	public SubButton minusButton = new SubButton(MINUS);
	public AddButton plusButton = new AddButton(PLUS);
	public ClrButton clearButton = new ClrButton(CLEAR);
	public EqualsButton equalsButton = new EqualsButton(EQUALS);
	public static CalculatorView cv;

	public CalculatorView(CalculatorModel model, CalculatorController controller) {
		super(model, controller);

		textField.setText("0");
		this.getContentPane().add(textField, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
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
		jButton1.addActionListener(numhandler);
		jButton2.addActionListener(numhandler);
		jButton3.addActionListener(numhandler);
		jButton4.addActionListener(numhandler);
		jButton5.addActionListener(numhandler);
		jButton6.addActionListener(numhandler);
		jButton7.addActionListener(numhandler);
		jButton8.addActionListener(numhandler);
		jButton9.addActionListener(numhandler);
		jButton0.addActionListener(numhandler);
		minusButton.addActionListener(subhandler);
		plusButton.addActionListener(addhandler);
		clearButton.addActionListener(clrhandler);
		equalsButton.addActionListener(eqhandler);
		this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		pack();

	}

	// Now implement the necessary event handling code
	public void modelChanged(ModelEvent event) {
		System.out.println("CalculatorView.modelChanged(ModelEvent event)");
		String msg = event.getAmount() + "";
		textField.setText(msg);
		System.out.println("\t" + msg);
	}

	// Inner classes for Event Handling
	public abstract class Handler implements ActionListener {
		// Event handling is handled locally
//		public void actionPerformed(ActionEvent e) {
//			System.out.println(".");
//		}
		public abstract void actionPerformed(ActionEvent e);
	}

	// Inner classes for Event Handling
	public class EqHandler extends Handler {
		public void actionPerformed(ActionEvent e) {
			System.out.println("EqHandler.actionPerformed(ActionEvent e)");
			CalculatorController c = (CalculatorController) getController();
			c.equalsOperation();
		}

	}

	// Inner classes for Event Handling
	public class AddHandler extends Handler {
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			System.out.println("AddHandler.actionPerformed(ActionEvent e)");
			CalculatorController c = (CalculatorController) getController();
			c.addOperation();
		}
	}

	// Inner classes for Event Handling
	public class SubHandler extends Handler {
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			System.out.println("SubHandler.actionPerformed(ActionEvent e)");
			CalculatorController c = (CalculatorController) getController();
			c.subOperation();
		}
	}

	// Inner classes for Event Handling
	public class ClrHandler extends Handler {
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			System.out.println("ClrHandler.actionPerformed(ActionEvent e)");
			CalculatorController c = (CalculatorController) getController();
			c.clrOperation();
		}
	}

	// Inner classes for Event Handling
	public class NumHandler extends Handler {
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			System.out.println("NumHandler.actionPerformed(ActionEvent e)");
			CalculatorController c = (CalculatorController) getController();
			String ae = e.getActionCommand();
			c.numOperation(ae);
		}
	}

	public static void main(String[] args) {
		int a = 1;
		int b = 3;
		System.out.println("CalculatorView.main(String[] args)");

		CalculatorController cc = new CalculatorController();
		cv = (CalculatorView) cc.getView();

		start(a, b);

	}

	static void start(int a, int b) {
		System.out.println("CalculatorView.start(int a, int b)");
		if (a > b) {
			addition(cv, a, b);
		} else if (a < b) {
			subtraction(cv, b, a);
		}
		equalsMethod(cv);
	}

	static void addition(CalculatorView calc, int a, int b) {
		System.out.println("CalculatorView.addition(CalculatorView calc, int a, int b)");
		(new Thread(new RunnableLinkedList())).start();
		pickButton(calc, a);
		calc.plusButton.pushed();
		pickButton(calc, b);
	}

	static void subtraction(CalculatorView calc, int a, int b) {
		System.out.println("CalculatorView.subtraction(CalculatorView calc, int a, int b)");
		(new Thread(new RunnableLinkedList())).start();
		pickButton(calc, b);
		calc.minusButton.pushed();
		pickButton(calc, a);
	}

	static void equalsMethod(CalculatorView calc) {
		System.out.println("CalculatorView.equalsMethod(CalculatorView calc)");
		calc.equalsButton.pushed();
		(new Thread(new RunnableLinkedList())).start();
	}

	static void pickButton(CalculatorView calc, int val) {
		System.out.println("CalculatorView.pickButton(CalculatorView calc, int val)");
		(new Thread(new RunnableLinkedList())).start();
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
