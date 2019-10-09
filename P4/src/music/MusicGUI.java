package music;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.dnd.*;

import gui.CenterFrame;
import gui.Drawable;
import gui.DrawPanel;
import gui.EasyGridBag;

public class MusicGUI extends CenterFrame implements Drawable, ActionListener
{
	private JComboBox comboBoxArtists;
	private JComboBox comboBoxCDs;
	private ManySongs listSongs;
	private SingleSong listSong;
	
	public MusicGUI(int width, int height, java.util.Iterator<Artist> it)
	{
		super(width, height, "Music Collection");
		setLayout(new BorderLayout());
		JPanel center = new JPanel();
		add(center, BorderLayout.CENTER);
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1,2));
		comboBoxArtists = new JComboBox();
		comboBoxCDs = new JComboBox();
		northPanel.add(comboBoxArtists);
		northPanel.add(comboBoxCDs);
		add(northPanel, BorderLayout.NORTH);
		
		Dimension dimension = new Dimension(10, 17);
		listSong = new SingleSong();
		listSong.setPreferredSize(dimension);
		

		JPanel scrollPanel = new JPanel();
		scrollPanel.setLayout(new BorderLayout());
		//scrollPanel.add(scrollSongsPane, BorderLayout.CENTER);
		scrollPanel.add(listSong, BorderLayout.SOUTH);
		
		DrawPanel drawPanel = new DrawPanel();
		drawPanel.setDrawable(this);
		
		listSongs = new ManySongs();
		listSongs.setFont(new Font("Courier New", Font.PLAIN, 12));
		listSongs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollSongsPane = new JScrollPane();
		scrollSongsPane.setPreferredSize(dimension);
		scrollSongsPane.getViewport().add(listSongs);
		
		scrollPanel.add(scrollSongsPane, BorderLayout.CENTER);
		
		EasyGridBag easyGridBag = new EasyGridBag(1, 4, center);
		center.setLayout(easyGridBag);
		
		easyGridBag.fillCellWithRowColSpan(1, 2, 1, 4, GridBagConstraints.BOTH, drawPanel);;
		easyGridBag.fillCellWithRowColSpan(1, 1, 1, 1, GridBagConstraints.BOTH, scrollPanel);
		
		DragSource dragSource = DragSource.getDefaultDragSource();
		DragGestureRecognizer dgr = dragSource.createDefaultDragGestureRecognizer(listSongs, DnDConstants.ACTION_COPY, listSongs);
		DropTarget dropTarget = new DropTarget(listSong, listSong);  //use the interfaces implemented in this class
		
		//Order Here Is Important
		fillArtists(it);
		
		comboBoxArtists.setActionCommand("artist");
		comboBoxArtists.addActionListener(this);
		
		//next line generates an event and fillCDs is called
		//fillCDs adds an ActionListener to the CDs combo box (so don't do this twice)
		//a CD event is not generated as the setActionCommand has not occurred
		comboBoxArtists.setSelectedIndex(0);
		
		comboBoxCDs.setActionCommand("CDs");
		//Now a CD Event is generated and the songs list box is populated
		comboBoxCDs.setSelectedIndex(0);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent actionEvent)
	{
		if(actionEvent.getActionCommand().equals("artist"))
		{
			Artist artist = (Artist) comboBoxArtists.getSelectedItem();
			//Careful!!: Stop Event handling temporarily!!
			comboBoxCDs.removeActionListener(this);
			fillCDs(artist);
			comboBoxCDs.addActionListener(this);
			comboBoxCDs.setSelectedIndex(0); //Triggers an Event
		}
		else if(actionEvent.getActionCommand().equals("CDs"))
		{
			CD cd = (CD) comboBoxCDs.getSelectedItem();
			listSongs.setCD(cd);
		}
		
		repaint();
	}
	
	private void fillCDs(Artist artist)
	{
		comboBoxCDs.removeAllItems();
		java.util.Iterator<CD> iter = artist.iterator();
		while(iter.hasNext())
		{
			comboBoxCDs.addItem(iter.next());
		}
	}
	
	private void fillArtists(java.util.Iterator<Artist> iter)
	{
		while(iter.hasNext())
		{
			comboBoxArtists.addItem(iter.next());
		}
		comboBoxArtists.setSelectedIndex(0);
	}
	
	//the Draw Panel calls this method when a repaint occurs
	//This is because the combo box with the selected CD can only be accessed here
	public void draw(Graphics g, int width, int height)
	{
		int colWidth = width/2;
		int colHeight = height/2;
		CD cdImage = (CD) comboBoxCDs.getSelectedItem();
		cdImage.draw(g, colWidth, colHeight);
	}
	
	//Draw Panel calls this method for the same reason as above
	public void mouseClicked(int x, int y)
	{
		CD cdImage = (CD) comboBoxCDs.getSelectedItem();
		cdImage.mouseClicked(x,y);
	}
	
	public void keyPressed(char key)
	{
		
	}
}