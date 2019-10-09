package util;

public abstract class KeyedItem
{
  private String search_key;
  
  public KeyedItem(String key) 
  {
    search_key = key;
  }  

  public String getKey() 
  {
    return search_key;
  }
}
