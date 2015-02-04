package calc.controller;

import calc.model.CalculatorModel;
import calc.view.CalculatorView;
import calc.view.JFrameView;

public class CalculatorController extends AbstractController {
	public CalculatorController() {
		CalculatorModel cm = new CalculatorModel();
		setModel(cm);
		CalculatorView cv = new CalculatorView(cm, this);
		setView(cv);
		((JFrameView) getView()).setVisible(true);
	}

	public void equalsOperation() {
		CalculatorModel cm = (CalculatorModel) getModel();
		cm.equalsOp();
	}

	public void addOperation() {
		CalculatorModel cm = (CalculatorModel) getModel();
		cm.add();
	}

	public void subOperation() {
		CalculatorModel cm = (CalculatorModel) getModel();
		cm.subtract();
	}

	public void clrOperation() {
		CalculatorModel cm = (CalculatorModel) getModel();
		cm.clear();
	}

	public void numOperation(String option) {
		CalculatorModel cm = (CalculatorModel) getModel();
		int val = Integer.parseInt(option);
		cm.store(val);
	}

}
