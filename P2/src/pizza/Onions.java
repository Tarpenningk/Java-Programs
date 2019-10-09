package pizza;

public class Onions extends DecoratedPizza
{
	
	String name;
	String abbreviation;
	double cost;
	
	public Onions(DecoratedPizza decorPizza)
	{
		super(decorPizza);
		name = "Onions";
		abbreviation = "O";
		cost = 0.79;
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