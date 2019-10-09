package pizza;

public class Pizza extends DecoratedPizza
{
	private Crust crust;
	
	public Pizza()
	{
		super();
		crust = new Crust("S", "THIN");
	}
	
	public Pizza(String size, String type)
	{
		crust = new Crust(size, type);
	}
	
	public double pizzaCost() //get the cost from the "next_pizza_item" DecoratedPizza
	{
		return crust.pizzaCost();
	}
	public String toString() //get the state of the "next_pizza_item" DecoratedPizza
	{
		return crust.toString();
	}
	public String getImage() //get the abbreviation of the "next_pizza_item" DecoratedPizza
	{
		return crust.getImage();
	}
}