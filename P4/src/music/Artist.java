package music;

import table.*;

public class Artist
{
	private String artist;
	private TableInterface<CD, String> artistsCD;
	
	public Artist(String artist)
	{
		this.artist = artist;
		artistsCD = TableFactory.createTable(new CompareCDTitles(true)); 
	}
	
	public void addCD(CD cd) throws TableException
	{
		artistsCD.tableInsert(cd);
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public java.util.Iterator<CD> iterator()
	{
		return artistsCD.iterator();
	}
	
	public String toString()
	{
		return getArtist();
	}
}