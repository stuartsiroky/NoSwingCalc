package calc.model;

public class CalculatorModel extends AbstractModel {
	private int total = 0;
	private int current = 0;
	private String state = "add";
	
	public void clear(){total = 0; store(0);}
	
	public void store(int value){
		current = value;
		ModelEvent me = new ModelEvent(this, 1, "", current);
		System.out.println("model.store::"+value);
		notifyChanged(me);
	}
	
	public void notifyChanged(ModelEvent event){
	super.notifyChanged(event);
	}
	public void add()//throws Digit5
	{//if(current == 5) throw new Digit5("method add class CalculatorModel: current is 5");
		state = "add"; total = current;
		System.out.println("STUART CalculatorModel.add");
		}
	
	public void subtract(){state = "subtract"; total = current;
	System.out.println("STUART CalculatorModel.subtract");
	}
	
	public void equals(){
		if(state == "add"){
			total += current;
		}
		else {
			total -= current;
		}
		current = total;
		ModelEvent me = new ModelEvent(this, 1, "", total);
		System.out.println("model.equals:: state = "+state+" total = "+current);
		notifyChanged(me);
	}

		public int getTotal(){return total;} 
}
