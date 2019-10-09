package mastermind;
import util.Random;
import java.util.*;

public class MasterMindAIConsistent implements MasterMindAI
{
   private Random randomGuess;
   private MasterMind master_mind;
   
   public MasterMindAIConsistent(MasterMind mm)
   {
	   master_mind = mm;	
   }  
	
	public Guess nextGuess()
	{ 
		MasterMindAI aiRandom = new MasterMindAIRandom(master_mind);
		Guess randomGuess = aiRandom.nextGuess();
		int numberOFGuessess = master_mind.getNumGuesses();
		
		if(numberOFGuessess == 0)
		{
			return randomGuess;
		}
		
		for(int i =0; i< numberOFGuessess; i++)
		{
			Guess tempGuess = master_mind.getGuess(i+1);
			int[] result = master_mind.reportTestResult(randomGuess, tempGuess);
				   
			if(result[0] != tempGuess.getNumBlack() || result[1] != tempGuess.getNumWhite())
			{
				i = -1;
				randomGuess = aiRandom.nextGuess();
			}
	   }
	   return randomGuess;
	}
}