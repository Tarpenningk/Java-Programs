package mastermind;

public class MasterMindGameOverState implements MasterMindState
{
	private MasterMind masterMindGameOver;
	
   public MasterMindGameOverState(MasterMind mm)
   {
		masterMindGameOver = mm;
   }
   
   public void mouseClicked(int x_click, int y_click)
   {
	 if(masterMindGameOver.isGameOver())
	 {
		 return;
	 }
   }	
}