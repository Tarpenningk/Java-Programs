package pizza;
import util.ReadTextFile;

public class PizzaDriver
{	
	private static ReadTextFile readTextFile;
	private static double cost;
	public PizzaDriver()
	{
		
	}
	
    private static int menu() //show the menu choices, wait for and return the valid selection
    {
		int menuChoice;
		String readLine;
		
		System.out.println("1. Meat Lover's");
		System.out.println("2. Veggie Lover's");
		System.out.println("3. Hawaiian");
		System.out.println("4. Build Your Own");
		
		System.out.println("Select from the above: ");
		readLine = readTextFile.readLine();
		menuChoice = Integer.parseInt(readLine);
		
		while(menuChoice < 1 || menuChoice > 4)
		{
			System.out.println("Select from the above: ");
			readLine = readTextFile.readLine();
			menuChoice = Integer.parseInt(readLine);
		}
		
		return menuChoice;
		
	}
	private static void requestSize(PizzaBuilder pizza_builder) //request the crust size, wait for a valid response confirmation from PizzaBuilder
    {
		boolean flag = false;
		char size;
		String readLine;
		
		while(flag == false)
		{
			System.out.println("What size pizza (S/M/L)?");
			readLine = readTextFile.readLine();
			size = readLine.charAt(0);
			flag = pizza_builder.setSize(size);
		}
		
	}
	private static void requestCrust(PizzaBuilder pizza_builder) //request the crust type, wait for a valid response confirmation from PizzaBuilder
    {
		boolean flag = false;
		String readLine;
		
		while(flag == false)
		{
			System.out.println("What type of crust (thin/hand/pan)?");
			readLine = readTextFile.readLine();
			flag = pizza_builder.setCrust(readLine);
		}
	
	}
	private static void requestToppings(PizzaBuilder pizza_builder) //ask for toppings until Done indicated (invalid toppings are ignored)
    {
		boolean again = true;
		char topping;
		String readLine;
		
		while(again == true)
		{
			System.out.println("(P)epperoni, (O)nions, (G)reen Peppers, (S)auasage,(M)ushrooms, (D)one");
			readLine = readTextFile.readLine();

			topping = readLine.charAt(0);
			pizza_builder.addTopping(topping);
			
			if(readLine.equals("d") || readLine.equals("D"))
			{
				again = false;
				System.out.println("Done Adding Toppings");
			}
		}

	}
	private static void showOrder(DecoratedPizza dec_pizza) //display the pizza and its total cost
    {
		cost += dec_pizza.pizzaCost();
		System.out.println("The cost of your pizza is $" + cost);
		
		System.out.println("Your pizza: ");
		String pizzaOrder = dec_pizza.toString();
		System.out.println("Size: " + pizzaOrder.charAt(0));
		System.out.println("Crust: " + pizzaOrder.charAt(1));
		System.out.println("Toppings: " + pizzaOrder);
	}
	public static void main (String[] args) //allow the user to order multiple pizzas if desired, call the other methods, track total cost and number of pizzas
	{
		//Variables needed
		PizzaBuilder pizzaBuilder = new PizzaBuilder();
		String file = "pizza_input_0.txt";
		readTextFile = new ReadTextFile(file);
		char orderAgain = 'Y';
		int choice;
		String crustSize;
		String crustType;
		String line;
		DecoratedPizza decoratedPizza;
		
		//Asking User to Order Pizza
		System.out.println("Would you like to order a pizza?");
		line = readTextFile.readLine();
		orderAgain = line.charAt(0);
		
		while(orderAgain == 'Y' || orderAgain == 'y')
		{
			choice = menu();
			switch(choice)
			{
				//Meat Lover's
				case 1:
				{
					requestSize(pizzaBuilder);
					requestCrust(pizzaBuilder);
					System.out.println("Are you a senior citizen?");
					System.out.println("Do you need this pizza delivered?");
					MeatLover meatLoverPizza = new MeatLover();
					meatLoverPizza.buildPizza();
					decoratedPizza = meatLoverPizza.pizzaDone();
					showOrder(decoratedPizza);
				}
				//Veggie Lover's
				case 2:
				{
					requestSize(pizzaBuilder);
					requestCrust(pizzaBuilder);
					System.out.println("Are you a senior citizen?");
					System.out.println("Do you need this pizza delivered?");
					VeggieLover veggieLoverPizza = new VeggieLover();
					veggieLoverPizza.buildPizza();
					decoratedPizza = veggieLoverPizza.pizzaDone();
					showOrder(decoratedPizza);
				}
				//Hawaiian
				case 3:
				{
					requestSize(pizzaBuilder);
					requestCrust(pizzaBuilder);
					System.out.println("Are you a senior citizen?");
					System.out.println("Do you need this pizza delivered?");
					Hawaiian hawaiianPizza = new Hawaiian();
					hawaiianPizza.buildPizza();
					decoratedPizza = hawaiianPizza.pizzaDone();
					showOrder(decoratedPizza);
				}
				//Build Your Own
				case 4:
				{
					requestSize(pizzaBuilder);
					requestCrust(pizzaBuilder);
					requestToppings(pizzaBuilder);
					
					//Determines Need for Senior Discount
					System.out.println("Are you a senior citizen?");
					line = readTextFile.readLine();
					if(line.equals("Y") || line.equals("y"))
					{
						System.out.println("Senior Discount Added");
					}
					
					//Determines Need for Delivery Fee
					System.out.println("Do you need this pizza delivered?");
					line = readTextFile.readLine();
					if(line.equals("Y") || line.equals("y"))
					{
						System.out.println("Delivery Fee Added");
					}
					
					decoratedPizza = pizzaBuilder.pizzaDone();
					showOrder(decoratedPizza);
				}
				
				//Asking User if they'd like another
				System.out.println("Would you like to order a pizza?");
				line = readTextFile.readLine();
				orderAgain = line.charAt(0);
			}
		}
	}
}