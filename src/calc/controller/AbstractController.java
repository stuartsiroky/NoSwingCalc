package calc.controller;

import calc.model.Model;
import calc.view.View;

public abstract class AbstractController implements Controller {
	private View view;
	private Model model;

	public void setModel(Model model) {
		System.out.println("AbstractController.setModel(Model model)");
		this.model = model;
	}

	public Model getModel() {
		System.out.println("AbstractController.getModel()");
		return model;
	}

	public View getView() {
		System.out.println("AbstractController.getView()");
		return view;
	}

	public void setView(View view) {
		System.out.println("AbstractController.setView(View view)");
		this.view = view;
	}

}
