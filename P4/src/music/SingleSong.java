package music;

import javax.swing.JList;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class SingleSong extends JList implements MP3Listener, DropTargetListener
{
	private static String empty = new String("Drag a song here.");
	private Thread t;
	private MP3 mp3;
	
	public SingleSong()
	{
		super();
		setObject(empty);
		t = null;
		mp3 = null;
	}

	public SingleSong(Object obj)
	{
		super();
		setObject(obj);
		t = null;
		mp3 = null;
	}
	
	public void setObject(Object obj)
	{
		Object[] item = {obj};
		setListData(item);
	}
	
	public void drop(DropTargetDropEvent dtde)
	{
		Transferable transfer = dtde.getTransferable();
		DataFlavor[] flavors = transfer.getTransferDataFlavors();
		Song dropSong;
		
		try
		{
			dropSong = (Song) transfer.getTransferData(flavors[0]);
		}
		catch(UnsupportedFlavorException ufe)
		{
			dtde.rejectDrop();
			return;
		}
		catch(java.io.IOException ioe)
		{
			dtde.rejectDrop();
			return;
		}
		
		dtde.acceptDrop(DnDConstants.ACTION_COPY);
		
		dtde.dropComplete(true);
		
		setObject(dropSong);
		
		//have a check if the thread is terminated
		if (t != null && mp3 != null && t.getState() != Thread.State.TERMINATED)
		{
			mp3.stopThread();
		}
		
		
		//DO THIS
		//set up the MP3 class to be run in a Thread
		mp3 = new MP3(dropSong, this);
		t = new Thread(mp3);
		t.start();
	}
	
	public void dragEnter(DropTargetDragEvent dtde) {}
	public void dragExit(DropTargetEvent dte) {}
	public void dragOver(DropTargetDragEvent dtde) {}
	public void dropActionChanged(DropTargetDragEvent dtde) {}
	
	public void mp3Done()
	{
		setObject(empty);
	}
}