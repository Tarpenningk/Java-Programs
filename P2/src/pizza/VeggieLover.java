package pizza;

public class VeggieLover extends PizzaBuilder
{
	private String size;
	private String type;
	
	public VeggieLover()
	{
		size = super.getSize();
		type = super.getType();
		
		Pizza pizza = new Pizza(size, type);
	}
	
	public void buildPizza()
	{
		super.addTopping('O');
		super.addTopping('G');
		super.addTopping('M');
	}
	
	public DecoratedPizza pizzaDone()
	{
		return super.pizzaDone();
	}
}