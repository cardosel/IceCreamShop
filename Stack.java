public abstract interface Stack<T>
{
  public abstract boolean empty();
  
  public abstract T peek();
  
  public abstract T pop();
  
  public abstract void push(T paramT);
  
  public abstract String toString();
}
