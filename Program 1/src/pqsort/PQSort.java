package pqsort;
import util.KeyedItem;
public class PQSort
{
    public static <E extends KeyedItem> E[] pqSort(E[] unsorted_items, boolean tree) //generics
	{
		PQBST<E> pqBST = new PQBST<E>();
		PQSLL<E> pqSLL = new PQSLL<E>();
		int num_items = unsorted_items.length;
		Class cls = unsorted_items.getClass().getComponentType();
		E[] sortedArray = (E[])java.lang.reflect.Array.newInstance(cls, num_items);
		
		//If true, PQBST
		if(tree)
		{
			for(int i = 0; i < sortedArray.length; i++ )
			{
				pqBST.pqInsert(unsorted_items[i]);
			}
			for(int k = 0; !pqBST.pqIsEmpty(); k++)
			{
				sortedArray[k] = pqBST.pqRemove();
			}
		}
		else//PQSLL
		{
			for(int i = 0; i < sortedArray.length; i++ )
			{
				pqSLL.pqInsert(unsorted_items[i]);
			}
			for(int k = 0; !pqSLL.pqIsEmpty(); k++)
			{
				sortedArray[k] = pqSLL.pqRemove();
			}
		}
		
		return sortedArray;
	}
}
    