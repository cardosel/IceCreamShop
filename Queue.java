public abstract interface Queue<T>
{
  public abstract boolean empty();
  
  public abstract T peek();
  
  public abstract T dequeue();
  
  public abstract void enqueue(T paramT);
  
  public abstract String toString();
}
