package pizza;

public class PizzaBuilder
{
	DecoratedPizza topLink;
	String size;
	String type;

    protected void buildPizza() //create a Crust and a Pizza using that Crust based on the user's specifications (the Pizza is now ready for toppings)
    {
		Pizza pizza = new Pizza(size, type);
		System.out.println("Ready For Toppings");
	}
	
	public String getSize()
	{
		return size;
	}
	
	public String getType()
	{
		return type;
	}
	
	public PizzaBuilder() //start with a small, thin pizza with no toppings as the default
    {
		size = "S";
		type = "THIN";
		Pizza pizza = new Pizza(size, type);
	}
	
	public boolean setSize(char try_size) //returns true if the input was valid ("S" or "small", etc., not case sensitive)
    {
		if(try_size == 's' || try_size == 'S')
		{
			size = "S";
			System.out.println("Size Set");
			return true;
		}
		else if(try_size == 'm' || try_size =='M')
		{
			size = "M";
			System.out.println("Size Set");
			return true;
		}
		else if(try_size == 'l' || try_size =='L')
		{
			size = "L";
			System.out.println("Size Set");
			return true;
		}
		else
		{
			System.out.println("Size Not Set");
			return false;
		}
	}
	
	public boolean setCrust(String try_crust) //("thin", "hand", or "pan", not case sensitive)
    {
		if(try_crust.equals("thin") || try_crust.equals("THIN"))
		{
			type = "THIN";
			System.out.println("Type Set");
			return true;
		}
		else if(try_crust.equals("hand") || try_crust.equals("HAND"))
		{
			type = "HAND";
			System.out.println("Type Set");
			return true;
		}
		else if(try_crust.equals("pan") || try_crust.equals("PAN"))
		{
			type = "PAN";
			System.out.println("Type Set");
			return true;
		}
		else
		{
			System.out.println("Type Not Set");
			return false;
		}
	}
	
	public void addTopping(char topping_char) //compare the topping abbreviation to topping_char to determine which topping to add (using void here is convenient for the PizzaDriver, ignore invalid abbreviations)
    {
		if(topping_char == 'p' || topping_char == 'P')
		{
			topLink = new Pepperoni(topLink);
			System.out.println("Pepperoni Added");
		}
		
		if(topping_char == 's' || topping_char == 'S')
		{
			topLink = new Sausage(topLink);
			System.out.println("Sausage Added");
		}
		
		if(topping_char == 'o' || topping_char == 'O')
		{
			topLink = new Onions(topLink);
			System.out.println("Onions Added");
		}
		
		if(topping_char == 'g' || topping_char == 'G')
		{
			topLink = new GreenPeppers(topLink);
			System.out.println("GreenPeppers Added");
		}
		if(topping_char == 'm' || topping_char == 'M')
		{
			topLink = new Mushrooms(topLink);
			System.out.println("Mushrooms Added");
		}
		
		if(topping_char == 'h' || topping_char == 'H')
		{
			topLink = new Ham(topLink);
			System.out.println("Ham Added");
		}
		
		if(topping_char == 'a' || topping_char == 'A')
		{
			topLink = new Pineapple(topLink);
			System.out.println("Pineapple Added");
		}
	}
	
	public DecoratedPizza pizzaDone() //return the final DecoratedPizza and reset to the default pizza if another pizza is desired
	{
		return topLink;
		
		//Resets?
	}
}