package pizza;

public class MeatLover extends PizzaBuilder
{
	private String size;
	private String type;
	
	public MeatLover()
	{
		size = super.getSize();
		type = super.getType();
		
		Pizza pizza = new Pizza(size, type);
	}
	
	public void buildPizza()
	{
		super.addTopping('H');
		super.addTopping('S');
		super.addTopping('P');
	}
	
	public DecoratedPizza pizzaDone()
	{
		return super.pizzaDone();
	}
}