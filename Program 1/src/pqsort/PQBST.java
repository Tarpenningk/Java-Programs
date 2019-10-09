package pqsort;
import util.KeyedItem;

//DO THIS
//complete this class
public class PQBST<E extends KeyedItem>
{
	private BinarySearchTree<E> bst;
	
	public PQBST()
	{
		bst = new BinarySearchTree<E>();
	}
	
	public void pqInsert(E ki)
	{
		bst.insert(ki);
	}
	
	public E pqRemove()
	{
		E removed = bst.remove();
		return removed;
	}
	
	public boolean pqIsEmpty()
	{
		int size = bst.size();
		if(size <= 0)
		{
			return true;
		}
		return false;
	}
}