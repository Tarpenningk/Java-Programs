package music;

import javax.swing.JList;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;

public class ManySongs extends JList implements DragGestureListener
{
	private static String blank = new String(" ");
	
	public ManySongs()
	{
	   super();
	}
	
	public void setCD(CD cd)
	{
		int numTracks = cd.getNumTracks();
		
		Song[] songs = new Song[numTracks];
		for(int i = 0; i < numTracks; i++)
		{
			songs[i] = cd.getSong(i);
		}
		setListData(songs);
	}
	
	public void dragGestureRecognized(DragGestureEvent dragEvent)
	{
		SongTransferable transferable = new SongTransferable((Song)getSelectedValue());
		//Starts the dragging process 
		DragSource dragSource = dragEvent.getDragSource();
		dragSource.startDrag(dragEvent, DragSource.DefaultCopyDrop, transferable, null);
	}
}