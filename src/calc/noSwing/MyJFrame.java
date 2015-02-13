package calc.noSwing;

public class MyJFrame {

	public void pack() {
		System.out.println("MyJFrame.pack()");
	}

	public Container getContentPane() {
		System.out.println("MyJFrame.getContentPane()");
		return new Container();
	}

	public void setVisible(boolean b) {
		System.out.println("MyJFrame.setVisible(boolean b)");
	}

}
