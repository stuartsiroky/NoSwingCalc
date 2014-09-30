package calc.view;
//FORJPF import gov.nasa.jpf.vm.Verify;
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
	public static int fake_state = 0;
	private JTextField textField = new JTextField();
	public  JButton jButton1 = new JButton("1");
	public  JButton jButton2 = new JButton("2");
	public  JButton jButton3 = new JButton("3");
	public  JButton jButton4 = new JButton("4");
	public  JButton jButton5 = new JButton("5");
	public  JButton jButton6 = new JButton("6");
	public  JButton jButton7 = new JButton("7");
	public  JButton jButton8 = new JButton("8");
	public  JButton jButton9 = new JButton("9");
	public  JButton jButton0 = new JButton("0");
	public  JButton minusButton = new JButton(MINUS);
	public  JButton plusButton = new JButton(PLUS);
	public  JButton clearButton = new JButton(CLEAR);
	public  JButton equalsButton = new JButton(EQUALS);
	public Handler handler = new Handler();
	
	public CalculatorView(CalculatorModel model, CalculatorController controller) {
		super(model, controller);
		System.out.println("Initial");
		textField.setText("0");
		this.getContentPane().add(textField, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		//Handler handler = new Handler();
		//JButton jButton1 = new JButton("1");
		jButton1.addActionListener(handler);
		//JButton jButton2 = new JButton("2");
		jButton2.addActionListener(handler);
		//JButton jButton3 = new JButton("3");
		jButton3.addActionListener(handler);
		//JButton jButton4 = new JButton("4");
		jButton4.addActionListener(handler);
		//JButton jButton5 = new JButton("5");
		jButton5.addActionListener(handler);
		//JButton jButton6 = new JButton("6");
		jButton6.addActionListener(handler);
		//JButton jButton7 = new JButton("7");
		jButton7.addActionListener(handler);
		//JButton jButton8 = new JButton("8");
		jButton8.addActionListener(handler);
		//JButton jButton9 = new JButton("9");
		jButton9.addActionListener(handler);
		//JButton jButton0 = new JButton("0");
		jButton0.addActionListener(handler);
		//JButton minusButton = new JButton(MINUS);
		minusButton.addActionListener(handler);
		//JButton plusButton = new JButton(PLUS);
		plusButton.addActionListener(handler);
		//JButton clearButton = new JButton(CLEAR);
		clearButton.addActionListener(handler);
		//JButton equalsButton = new JButton(EQUALS);
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
			if(fake_state == 1){
				ModelEvent me = new ModelEvent(this, 101, "invalid path", -101);
				modelChanged(me);
			} else {
			CalculatorController c = (CalculatorController) getController();
			String ae = e.getActionCommand();
			c.operation(ae);
			((CalculatorController) getController()).operation(e
					.getActionCommand());
		    }
		}
	}

	public static void main(String[] args) {
		int a = 1;
		int b = 3;	
		//FORJPF 		int a = Verify.getInt(-1,2);
		//FORJPF 		int b = Verify.getInt(-1,2);
		CalculatorController cc = new CalculatorController();
		CalculatorView cv = (CalculatorView) cc.getView();
		//cv.jButton1.pushed();
		//cv.plusButton.pushed();
		//cv.jButton3.pushed();
		//cv.equalsButton.pushed();
		//cc.operation("1");
		//cc.operation(PLUS);
		//cc.operation("3");
		//cc.operation(EQUALS);
		start(cv,a,b);
	}
	static void start (CalculatorView calc, int a, int b) {
		if(a > b){
			fake_state = 0;
			addition(calc,a,b);	
		} else if(a < b) {
			fake_state = 0;
			subtraction(calc,b,a);
		} else {
			fake_state = 1;
			ActionEvent e = new ActionEvent(calc, 101, "101");
			calc.handler.actionPerformed(e);
		}
		
		equals(calc);
	}
	
	static void addition(CalculatorView calc, int a, int b){
		pickButton(calc,a);
		calc.plusButton.pushed();
		pickButton(calc,b);
	}
	
	static void subtraction(CalculatorView calc, int a, int b){
		pickButton(calc,b);
		calc.minusButton.pushed();
		pickButton(calc,a);
	}
	
	static void equals(CalculatorView calc){
		calc.equalsButton.pushed();
	}
	static void pickButton(CalculatorView calc, int val){
		switch(val) {
		case 0: calc.jButton0.pushed(); break;
		case 1: calc.jButton1.pushed(); break;
		case 2: calc.jButton2.pushed(); break;
		case 3: calc.jButton3.pushed(); break;
		case 4: calc.jButton4.pushed(); break;
		case 5: calc.jButton5.pushed(); break;
		case 6: calc.jButton6.pushed(); break;
		case 7: calc.jButton7.pushed(); break;
		case 8: calc.jButton8.pushed(); break;
		case 9: calc.jButton9.pushed(); break;
		}
	}

}
