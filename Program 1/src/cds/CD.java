package cds;
import util.KeyedItem;

public class CD extends KeyedItem
{
   private String title;
   private int year;
   private int count;
   private int rating;
   private String img;
   private Song[] songs;

   public CD (String title, String artist, int year, int rating, int tracks)
   {
	   //DO THIS
      //call the parent constructor
	  super(title);
	  
      this.year = year;
      img = artist + " - " + title + ".jpg";
      count = 0;
      songs = new Song[tracks];

      if (rating > 0 && rating <= 100)
      {
         this.rating = rating;
      }
      else
      {
         this.rating = 5;
      }
   }
   
   public String getTitle()
   {
      return getKey();
   }

   public int getYear()
   {
      return year;
   }

   public int getRating()
   {
      return rating;
   }

   public Song getSong(int index)
   {
      if (index >= 0 && index < songs.length)
      {
         return songs[index];
      }
      else
      {
         return null;
      }
   }

   public void addSong(Song song)
   {
      if (song != null && count < songs.length)
      {
         songs[count] = song;
         count++;
      }
   }

   public String toString()
   {
      return getKey() + "  " + year + "  " + rating + "  " + songs.length;
   }
}
