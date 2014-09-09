package calc.controller;
//import calc.model.Digit5;
import calc.model.CalculatorModel;
import calc.view.CalculatorView;
import calc.view.JFrameView;

public class CalculatorController extends AbstractController {
	public CalculatorController(){
		CalculatorModel cm = new CalculatorModel();
		setModel(cm);
		//setModel(new CalculatorModel());
		CalculatorView cv = new CalculatorView(cm,this);
		setView(cv);
		//setView(new CalculatorView((CalculatorModel)getModel(), this));
		((JFrameView)getView()).setVisible(true);
	}
	public void operation(String option){
		if(option.equals(CalculatorView.MINUS)){
			CalculatorModel cm = (CalculatorModel)getModel();
			cm.subtract();
			//((CalculatorModel)getModel()).subtract();
		}else if(option.equals(CalculatorView.PLUS)){
		//	try{
			CalculatorModel cm = (CalculatorModel)getModel();
			cm.add();
			//((CalculatorModel)getModel()).add();
		//	}catch(Digit5 ex)
		//	{System.out.println(ex.getMessage());}
		}else if(option.equals(CalculatorView.CLEAR)){
			CalculatorModel cm = (CalculatorModel)getModel();
			cm.clear();
			//((CalculatorModel)getModel()).clear();
		}else if(option.equals(CalculatorView.EQUALS)){
			CalculatorModel cm = (CalculatorModel)getModel();
			cm.equals();
			//((CalculatorModel)getModel()).equals();
		}else {
			CalculatorModel cm = (CalculatorModel)getModel();
			int val = Integer.parseInt(option);
			cm.store(val);
			//((CalculatorModel)getModel()).store(Integer.parseInt(option));
		}
	}
}
