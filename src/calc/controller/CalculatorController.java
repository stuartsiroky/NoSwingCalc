package calc.controller;

import calc.model.CalculatorModel;
import calc.view.CalculatorView;
import calc.view.JFrameView;

public class CalculatorController extends AbstractController {
	public CalculatorController() {
//		System.out.println("CalculatorController.CalculatorController()");
		CalculatorModel cm = new CalculatorModel();
		setModel(cm);
		CalculatorView cv = new CalculatorView(cm, this);
		setView(cv);
		((JFrameView) getView()).setVisible(true);
	}

	public void equalsOperation() {
		System.out.println("CalculatorController.equalsOperation()");
		CalculatorModel cm = (CalculatorModel) getModel();
		cm.equalsOp();
	}

	public void addOperation() {
		System.out.println("CalculatorController.addOperation()");
		CalculatorModel cm = (CalculatorModel) getModel();
		cm.add();
	}

	public void subOperation() {
		System.out.println("CalculatorController.subOperation()");
		CalculatorModel cm = (CalculatorModel) getModel();
		cm.subtract();
	}

	public void clrOperation() {
		System.out.println("CalculatorController.clrOperation()");
		CalculatorModel cm = (CalculatorModel) getModel();
		cm.clear();
	}

	public void numOperation(String option) {
		System.out.println("CalculatorController.numOperation(String option)");
		CalculatorModel cm = (CalculatorModel) getModel();
		int val = Integer.parseInt(option);
		cm.store(val);
	}

}
