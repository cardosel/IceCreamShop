public class StackLL<T>
  implements Stack<T>
{
  private LinkedList<T> list;
  
  public StackLL()
  {
    this.list = new LinkedList<T>();
  }
  
  public boolean empty()
  {
    return this.list.isEmpty();
  }
  
  public T peek()
  {
    return (T)this.list.getFirst();
  }
  
  public T pop()
  {
    T poppedData = this.list.getFirst();
    
    this.list.deleteFirst();
    
    return poppedData;
  }
  
  public void push(T data)
  {
    this.list.insertFirst(data);
  }
  
  public String toString()
  {
    return this.list.toString();
  }
}
