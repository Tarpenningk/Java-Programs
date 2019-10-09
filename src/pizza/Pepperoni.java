package pizza;

public class Pepperoni extends DecoratedPizza
{
	
	String name;
	String abbreviation;
	double cost;
	
	public Pepperoni(DecoratedPizza decorPizza)
	{
		super(decorPizza);
		name = "Pepperoni";
		abbreviation = "P";
		cost = 0.99;
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