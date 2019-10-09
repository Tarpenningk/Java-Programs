package mastermind;

public class MasterMindPlayerState implements MasterMindState
{
	private MasterMind masterMindPlayer;
	
	public MasterMindPlayerState(MasterMind mm)
	{
		masterMindPlayer = mm;
	}
	
	public void mouseClicked(int x_click, int y_click)
	{
		int ai = masterMindPlayer.changeAI(x_click, y_click);
		
		if(ai == 1)
		{
			masterMindPlayer.changeState(masterMindPlayer.getAIState());
		}
		else if(ai == 2)
		{
			masterMindPlayer.changeState(masterMindPlayer.getAIState());
		}
		else if(ai == 3)
		{
			masterMindPlayer.changeState(masterMindPlayer.getAIState());
		}
		
		int color = masterMindPlayer.isColorSelected(x_click, y_click);
		if(color > 0)
		{
			masterMindPlayer.addGuess(color);
		}
	
		if(masterMindPlayer.isGameOver())
		{
			masterMindPlayer.changeState(masterMindPlayer.getGameOverState());
		}
		

	}
}