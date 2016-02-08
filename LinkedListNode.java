public class LinkedListNode<T>
{
  private T data;
  private LinkedListNode<T> next;
  
  public LinkedListNode(T data)
  {
    this.data = data;
    this.next = null;
  }
  
  public LinkedListNode()
  {
    this.data = null;
    this.next = null;
  }
  
  public T getData()
  {
    return (T)this.data;
  }
  
  public void setData(T data)
  {
    this.data = data;
  }
  
  public LinkedListNode<T> getNext()
  {
    return this.next;
  }
  
  public void setNext(LinkedListNode<T> node)
  {
    this.next = node;
  }
  
  public String toString()
  {
    if (this.data == null) {
      return "null";
    }
    return this.data.toString();
  }
}
