package pizza;

public class Hawaiian extends PizzaBuilder
{
	private String size;
	private String type;
	
	public Hawaiian()
	{
		size = super.getSize();
		type = super.getType();
		
		Pizza pizza = new Pizza(size, type);
	}
	
	public void buildPizza()
	{
		super.addTopping('h');
		super.addTopping('a');
	}
	
	public DecoratedPizza pizzaDone()
	{
		return super.pizzaDone();
	}
}