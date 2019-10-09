package pqsort;
import util.KeyedItem;

public class SortedListLinked <E extends KeyedItem>
{
   private Node<E> head;  
   private int size;

   public SortedListLinked() 
   {
      head = null;
      size = 0;
   } 
   
   public boolean isEmpty() 
   {
      return (size == 0);
   }  

   public int size() 
   {
      return size;
   }  

   public E remove()
   {  
	 //DO THIS
	 //remove the smallest item
	 Node<E> current = head;
	 Node<E> newHead = head.getNext();
	 head = newHead;
	 size--;
	 return current.getItem();
   }

   private Node<E> locateNodeAdd(E item) 
   {
      //DO THIS
      //find the insertion location (remember FIFO for duplicates)
	  if(head != null)
	  {
	
		Node<E> curr = head;
        Node<E> prev = null;
	    E currentItem = curr.getItem();
		
	    while( currentItem.getKey().compareTo(item.getKey()) <= 0)
	    {
		  prev = curr;
		  curr = curr.getNext();
		if(curr == null)
		{
		  break;
		}
		currentItem = curr.getItem();
	    } 
		  return prev;
	    }
	    else
	    {
		  return head;
	    }
   }

   public void add(E item)
   {
      Node<E> prev = locateNodeAdd(item);

      if(prev == null)
      {
         //insert the new node containing the new item at the beginning of the list
         Node<E> node = new Node<E>(item);
         node.setNext(head);
         head = node;
      } 
      else 
      {
         //insert the new node containing the new item after the node that prev references
         Node<E> node = new Node<E>(item);
         node.setNext(prev.getNext());
         prev.setNext(node);
      } 

      size++;
   }  
} 