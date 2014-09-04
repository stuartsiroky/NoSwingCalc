package calc.view;

//import javax.swing.*; 
//import java.awt.*; 
//import java.awt.event.*;

import calc.controller.CalculatorController;
import calc.model.CalculatorModel;
import calc.model.ModelEvent;
import calc.noSwing.ActionEvent;
import calc.noSwing.ActionListener;
import calc.noSwing.BorderLayout;
import calc.noSwing.GridLayout;
import calc.noSwing.JButton;
import calc.noSwing.JPanel;
import calc.noSwing.JTextField;

public class CalculatorView extends JFrameView {
	public static final String PLUS = "+";
	public static final String MINUS = "-";
	public static final String CLEAR = "Clr";
	public static final String EQUALS = "=";
	private JTextField textField = new JTextField();

	public CalculatorView(CalculatorModel model, CalculatorController controller) {
		super(model, controller);
		System.out.println("Initial");
		textField.setText("0");
		this.getContentPane().add(textField, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		Handler handler = new Handler();
		JButton jButton1 = new JButton("1");
		jButton1.addActionListener(handler);
		JButton jButton2 = new JButton("2");
		jButton2.addActionListener(handler);
		JButton jButton3 = new JButton("3");
		jButton3.addActionListener(handler);
		JButton jButton4 = new JButton("4");
		jButton4.addActionListener(handler);
		JButton jButton5 = new JButton("5");
		jButton5.addActionListener(handler);
		JButton jButton6 = new JButton("6");
		jButton6.addActionListener(handler);
		JButton jButton7 = new JButton("7");
		jButton7.addActionListener(handler);
		JButton jButton8 = new JButton("8");
		jButton8.addActionListener(handler);
		JButton jButton9 = new JButton("9");
		jButton9.addActionListener(handler);
		JButton jButton0 = new JButton("0");
		jButton0.addActionListener(handler);
		JButton minusButton = new JButton(MINUS);
		minusButton.addActionListener(handler);
		JButton plusButton = new JButton(PLUS);
		plusButton.addActionListener(handler);
		JButton clearButton = new JButton(CLEAR);
		clearButton.addActionListener(handler);
		JButton equalsButton = new JButton(EQUALS);
		equalsButton.addActionListener(handler);
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
		System.out.println("modeChanged::msg = "+msg);
	}

	// Inner classes for Event Handling
	public class Handler implements ActionListener {
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			((CalculatorController) getController()).operation(e
					.getActionCommand());
		}
	}

	public static void main(String[] args) {
		CalculatorController cc = new CalculatorController();
		cc.operation("1");
		cc.operation(PLUS);
		cc.operation("3");
		cc.operation(EQUALS);
	}

}
