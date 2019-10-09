package mastermind;
import util.Random;

public class MasterMindAIRandom implements MasterMindAI
{
	private Random randomGuess;
	private MasterMind master_mind;
	private Guess aiGuess;
	
	public MasterMindAIRandom(MasterMind mm)
	{
		master_mind = mm;
		randomGuess = Random.getRandomNumberGenerator();
	}
	
	public Guess nextGuess()
	{				
	    int num_guesses = master_mind.getNumGuesses();
		aiGuess = new Guess(num_guesses + 1);
		while(!aiGuess.isFull())
		{
			int randomColor = randomGuess.randomInt(1,7);
			aiGuess.addColor(randomColor);
		}
		return aiGuess;
	}
}
   