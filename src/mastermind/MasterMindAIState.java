package mastermind;

public class MasterMindAIState implements MasterMindState
{	
	private MasterMind master_mind;
	private MasterMindAI[] master_mind_ais;
	private MasterMindAI current_ai;

	public MasterMindAIState(MasterMind mm)
	{
		master_mind = mm;
		master_mind_ais = new MasterMindAI[3];
		master_mind_ais[0] = new MasterMindAIRandom(master_mind);
		master_mind_ais[1] = new MasterMindAIConsistent(master_mind);
		master_mind_ais[2] = new MasterMindAIMiniMax(master_mind);
		
		current_ai = master_mind_ais[0];
	}
	
	//Change AI Method
	public void changeAI(int ai)
	{
		current_ai = master_mind_ais[ai - 1];
	}
	
	public void mouseClicked(int x_click, int y_click)
	{
		int ai = master_mind.changeAI(x_click, y_click);
		System.out.println("AI: " + ai);
		
		//Human/Player
		if(ai == 0)
		{
			master_mind.changeState(master_mind.getPlayerState());
		}
	
		else if(ai > 0)
		{
			changeAI(ai);
			Guess nextGuess = new Guess(master_mind.getNumGuesses() + 1);
			nextGuess = current_ai.nextGuess();
			master_mind.addGuess(nextGuess);	
		}
		
		else if(ai < 0)
		{
			Guess nextGuess = new Guess(master_mind.getNumGuesses() + 1);
			nextGuess = current_ai.nextGuess();
			master_mind.addGuess(nextGuess);
		}
		
		if(master_mind.isGameOver())
		{
			master_mind.changeState(master_mind.getGameOverState());
		}
	}
}