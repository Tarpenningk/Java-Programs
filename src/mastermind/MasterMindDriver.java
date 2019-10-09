package mastermind;

public class MasterMindDriver
{
	//entry point
   public static void main(String[] args)
   {
	  int parameter = Integer.parseInt(args[0]);
	  boolean player = false;

	  if(args.length > 0)
	  {
		  if(parameter != 0)
		  {
			 player = true; 
			 MasterMind master_mind = new MasterMind(player);
		  }
		  else
		  {
			player = false;
			MasterMind master_mind = new MasterMind(player);
		  }
	  }
	  
	  
	  
   }
}
   