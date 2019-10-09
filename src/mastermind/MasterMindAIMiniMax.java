package mastermind;
import util.Random;
import java.util.*;

public class MasterMindAIMiniMax implements MasterMindAI
{	
	private MasterMind master_mind;
	private Random randomGuess;
	private ArrayList<Guess> allPossible;
	private ArrayList<Guess> possible;
	private ArrayList<Guess> badList;
	
	public MasterMindAIMiniMax(MasterMind mm)
	{
		master_mind = mm;
		randomGuess = Random.getRandomNumberGenerator();
		allPossible = new ArrayList<Guess>();
		fillList();
		possible = new ArrayList<Guess>();
		badList = new ArrayList<Guess>();
	}
	
	private void generateConsistent()
	{
		int numGuesses = master_mind.getNumGuesses();		
		int notConsistentCounter = 0;
		//go over allPossible guesses
		for(Guess guess : allPossible)
		{
			//go over all past guesses
			for(int i = 0; i < numGuesses; i++)
			{
				Guess prevGuess = master_mind.getGuess(i+1);
				//perform a reportTest for 
				int[] result = master_mind.reportTestResult(guess, prevGuess);
				//if the guess from allPossible is consistent with all past guesses
				if(result[0] != prevGuess.getNumBlack() || result[1] != prevGuess.getNumWhite())
				{
					notConsistentCounter++;
				}
				else
				{
					//then add that guess to possible
					possible.add(guess);
				}
			}
		}
	}
	
	public Guess nextGuess()
	{
		//If it's the first guess, to save time return a Guess of four different colors.
		int numGuesses = master_mind.getNumGuesses();
		if(numGuesses == 0)
		{
			Guess firstGuess = new Guess(numGuesses + 1);
			firstGuess.addColor(1);
			firstGuess.addColor(2);
			firstGuess.addColor(3);
			firstGuess.addColor(4);
			
			return firstGuess;
		}
		
		//generate all consistent guesses among allPossible and save them to possible
		generateConsistent();
		
		int max = -100000;
		Guess good_guess = new Guess(numGuesses + 1);
		
		//go over allPossible guesses
		for (Guess guess : allPossible)
		{
			int min = 100000;
			int counter = 0;
			//go over all black pegs
			for (int black = 0; black <= 4; black++)
			{
				//go over all white pegs
				for (int white = 0; white <= 4 - black; white++)
				{
					// at this point we will know our possible feedback of black and white pegs
					//go over every poss_secret and test your guess against those poss_secrets
					for (Guess poss_secret : possible)
					{
						int[] result = master_mind.reportTestResult(guess, poss_secret);
						//when the guess is NOT consistent, you increment your counter
						//compare your result[0] with black and result [1] with white
						if(result[0] != black || result[1] != white)
						{
							counter++;	
						}
					}	
				}
				//if counter < min, then min = counter
				if(counter < min)
				{
					min = counter;
				}
			}
			//if max < min, then max = min and save guess to good_guess and return it
			if(max < min)
			{
				max = min;
				good_guess = guess;
			}
		}
		return good_guess;
	}
	
	public void fillList()
	{
		Guess tempGuess;
		for(int i = 1; i <= 7; i++)
		{
			for(int j = 1; j <= 7; j++)
			{
				for(int k = 1; k <= 7; k++)
				{
					for(int l = 1; l <= 7; l++)
					{
						tempGuess = new Guess(master_mind.getNumGuesses() + 1); 
						tempGuess.addColor(i);
						tempGuess.addColor(j);
						tempGuess.addColor(k);
						tempGuess.addColor(l);
						allPossible.add(tempGuess);
					}
				}
			}
		}
	}
}