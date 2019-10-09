package pizza;

public class GreenPeppers extends DecoratedPizza
{
	
	String name;
	String abbreviation;
	double cost;
	
	public GreenPeppers(DecoratedPizza decorPizza)
	{
		super(decorPizza);
		name = "Green Peppers";
		abbreviation = "G";
		cost = 0.69;
	}
	
	public double pizzaCost() //return this cost and get the cost from the "next_pizza_item" DecoratedPizza
	{
		return cost + super.pizzaCost();
	}
	public String toString() //return this state and get the state of the "next_pizza_item" DecoratedPizza
	{
		return name + super.toString();
	}
	public String getImage() //return this abbreviation and get the abbreviation of the "next_pizza_item" DecoratedPizza
	{
		return super.getImage() + abbreviation;
	}
}