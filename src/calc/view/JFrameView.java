package calc.view;

import calc.controller.Controller;
import calc.model.AbstractModel;
import calc.model.Model;
import calc.model.ModelListener;
import calc.noSwing.MyJFrame;

abstract public class JFrameView extends MyJFrame implements View,
		ModelListener {

	private Model model;
	private Controller controller;

	public JFrameView(Model model, Controller controller) {
//		System.out.println("JFrameView.JFrameView(Model model, Controller controller)");
		setModel(model);
		setController(controller);
	}

	public void registerWithModel() {
		System.out.println("JFrameView.registerWithModel()");
		((AbstractModel) model).addModelListener(this);
	}

	public Controller getController() {
		System.out.println("JFrameView.getController()");
		return controller;
	}

	public void setController(Controller controller) {
		System.out.println("JFrameView.setController(Controller controller)");
		this.controller = controller;
	}

	public Model getModel() {
		System.out.println("JFrameView.getModel()");
		return model;
	}

	public void setModel(Model model) {
		System.out.println("JFrameView.setModel(Model model)");
		this.model = model;
		registerWithModel();
	}

}
