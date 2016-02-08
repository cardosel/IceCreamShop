public class QueueLL<T>
  implements Queue<T>
{
  private LinkedList<T> list;
  
  public QueueLL()
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
  
  public T dequeue()
  {
    T dequeuedData = this.list.getFirst();
    
    this.list.deleteFirst();
    
    return dequeuedData;
  }
  
  public void enqueue(T data)
  {
    this.list.insertLast(data);
  }
  
  public String toString()
  {
    return this.list.toString();
  }
  
  public int size(Queue<T> q)
  {
    int size = 0;
    while (!q.empty())
    {
      q.dequeue();
      size++;
    }
    return size;
  }
}
