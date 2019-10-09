package cds;

import util.ReadTextFile;
import pqsort.PQSort;
import java.util.ArrayList;
import java.util.Iterator;
import util.KeyedItem;

public class CDSort<E extends KeyedItem>
{

   public static void main (String[] args)
   {
      String file_name = "cds.txt";
	  
		//DO THIS
		//use pq sort on the array of cds
		//print out the cds showing sorted order by title
		KeyedItem[] unsorted = readMusic(file_name);
		KeyedItem[] sorted;
		
		
		//True for a Tree, false for a List
		System.out.println("Sorted by Binary Search Tree: ");
		sorted = PQSort.pqSort(unsorted, true);
		for(int i = 0; i < sorted.length; i++)
		{
			
			System.out.println(sorted[i].getKey());
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Sorted by Linked List: ");
		sorted = PQSort.pqSort(unsorted, false);
		for(int i = 0; i < sorted.length; i++)
		{
			
			System.out.println(sorted[i].getKey());
		}
   }

   private static CD[] readMusic(String file_name)
   {
	   ArrayList<CD> cds = new ArrayList<CD>();
	   
      ReadTextFile file = new ReadTextFile(file_name);
      String str = file.readLine();
      while (!file.EOF())
      {
         String title = file.readLine();
         int year = Integer.parseInt(file.readLine());
         int rating = Integer.parseInt(file.readLine());
         int numTracks = Integer.parseInt(file.readLine());
         CD cd = new CD(title, str, year, rating, numTracks);

         cds.add(cd);
         int tracks = 1;

         while (tracks <= numTracks)
         {
            String temp = file.readLine();
            String[] line = temp.split(",");
            String len = line[0];
            String songTitle = line[1];
            Song song = new Song(songTitle, len);
            cd.addSong(song);
            tracks++;
         }

         str = file.readLine();
      }
	  
	  int num_cds = cds.size();
	  CD[] cd_array = new CD[num_cds];
	  
	  int count = 0;
	  for (CD cd : cds)
	  {
		  cd_array[count] = cd;
		  count++;
	  }
	  
	  return cd_array;
   }
}
