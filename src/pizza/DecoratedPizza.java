package pizza;

public abstract class DecoratedPizza
{
	private DecoratedPizza next_pizza_item;
	
	public DecoratedPizza()
	{
		next_pizza_item = null;
	}
	
	public DecoratedPizza(DecoratedPizza next_pizza_item)
	{
		this.next_pizza_item = next_pizza_item;
	}
	
	public double pizzaCost() //get the cost from the "next_pizza_item" DecoratedPizza
	{
		return next_pizza_item.pizzaCost();
	}
	public String toString() //get the state of the "next_pizza_item" DecoratedPizza
	{
		return next_pizza_item.toString();
	}
	public String getImage() //get the abbreviation of the "next_pizza_item" DecoratedPizza
	{
		return next_pizza_item.getImage();
	}
	//(the topping abbreviation is used to obtain the correct pizza image)
}