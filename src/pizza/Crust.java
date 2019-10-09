package pizza;

public class Crust
{	
	private String size;
	private String type;

	public Crust(String s, String t)
	{
		size = s.toUpperCase();
		type = t.toUpperCase();
	}
	
	public String getCrust()
	{
		return type;
	}
	
	public char getSize()
	{
		if(size.equals("S"))
		{
			return 'S';
		}
		else if(size.equals("M"))
		{
			return 'M';
		}
		else
		{
			return 'L';
		}
	}
	
	public String toString()
	{
		return (size + " " + type);
	}
	
	public String getImage() //get the abbreviation of the "next_pizza_item" DecoratedPizza
	{
		return size;
	}
	
	public double pizzaCost() //get the cost from the "next_pizza_item" DecoratedPizza
	{
		double sum = 0;
		//Get crust size cost
		if(size.equals("S"))
		{
			sum += CrustSize.S.getCost();
		}
		else if(size.equals("M"))
		{
			sum += CrustSize.M.getCost();
		}
		else
		{
			sum += CrustSize.L.getCost();
		}
		//Get crust type cost
		if(type.equals("THIN"))
		{
			sum += CrustType.THIN.getCost();
		}
		else if(type.equals("PAN"))
		{
			sum += CrustType.PAN.getCost();
		}
		else
		{
			sum += CrustType.HAND.getCost();
		}
		
		return sum;
	}
}