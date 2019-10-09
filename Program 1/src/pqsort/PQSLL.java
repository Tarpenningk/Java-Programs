package pqsort;
import util.KeyedItem;

public class PQSLL<E extends KeyedItem>
{
	private SortedListLinked<E> sll;
	
	public PQSLL()
	{
		sll = new SortedListLinked<E>();
	}
	
	public void pqInsert(E ki)
	{
		sll.add(ki);
	}
	
	public E pqRemove()
	{
		return sll.remove();
	}
	
	public boolean pqIsEmpty()
	{
		return sll.isEmpty();
	}
	
}
