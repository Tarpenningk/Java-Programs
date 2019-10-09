package pqsort;
import util.KeyedItem;

public class BinarySearchTree<E extends KeyedItem>
{
	private TreeNode<E> root;
	private int size;
   
    public int size()
   {
      return size;
   }
   
   public BinarySearchTree()
   {
      root = null;
   } 

   public void insert(E item)
   {
      root = insertItem(root, item);
      size++;
   }  
   
   //DO THIS
   //complete this method
   public E remove()
   {
	   //get the leftmost item (call findleftmost)
	   //go back down the tree and remove that node
	   E item;
	   if (root.getLeft() == null)
	   {
		  item = root.getItem();
		  root = root.getRight();
	   }
	   else
	   {
		  item = findLeftmost(root);
		  root = removeLeftmost(root);
	   }

	   
	   size--;
	   return item;
   }
   
   //DO THIS
   //complete this recursive method
   //duplicates should be placed on the right
    private TreeNode<E> insertItem(TreeNode<E> tNode, E item)
   {
	   
      if( tNode == null)
	  {	
		TreeNode<E> newNode = new TreeNode<E>(item);
		return newNode;
	  }  
	  
	  else 
	  {
		 TreeNode<E> left = tNode.getLeft();
	     TreeNode<E> right = tNode.getRight(); 
	     E nodeItem = tNode.getItem();
	  	 int i = item.getKey().compareTo(nodeItem.getKey());		 
	  if( i < 0) 
	  {
		 TreeNode<E> temp = insertItem(left, item);
		 tNode.setLeft(temp);
		 return tNode;
	  }
	  else
	  {
		 TreeNode<E> temp = insertItem(right, item);
		 tNode.setRight(temp);
		 return tNode;
	  }
	 }
   }
   
   private E findLeftmost(TreeNode<E> tNode)  
   {
	   //DO THIS
	  while(tNode.getLeft() != null)
	  {
		  tNode = tNode.getLeft();
	  }
	  return tNode.getItem();

   } 

   //can also be done non-recursively with a different method signature
   private TreeNode<E> removeLeftmost(TreeNode<E> tNode)
   {
	   if (tNode.getLeft() == null)
	   {
		   return tNode.getRight();
	   }
	   else
	   {
		   TreeNode<E> subtree = removeLeftmost(tNode.getLeft());
		   tNode.setLeft(subtree);
		   return tNode;
	   }
   } 
}