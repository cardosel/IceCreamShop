public class LinkedList<T>
{
  private LinkedListNode<T> head;
  private LinkedListNode<T> tail;
  
  public LinkedList()
  {
    this.head = null;
    this.tail = null;
  }
  
  public T getFirst()
  {
    if (getFirstNode() == null) {
      return null;
    }
    return (T)getFirstNode().getData();
  }
  
  public LinkedListNode<T> getFirstNode()
  {
    return this.head;
  }
  
  public T getLast()
  {
    if (getLastNode() == null) {
      return null;
    }
    return (T)getLastNode().getData();
  }
  
  public LinkedListNode<T> getLastNode()
  {
    return this.tail;
  }
  
  public void insertFirst(T data)
  {
    insertFirstNode(new LinkedListNode<T>(data));
  }
  
  public void insertFirstNode(LinkedListNode<T> node)
  {
    node.setNext(this.head);
    
    this.head = node;
    if (isEmpty()) {
      this.tail = node;
    }
  }
  
  public void insertAfter(LinkedListNode<T> currentNode, T data)
  {
    insertNodeAfter(currentNode, new LinkedListNode<T>(data));
  }
  
  public void insertNodeAfter(LinkedListNode<T> currentNode, LinkedListNode<T> node)
  {
    node.setNext(currentNode.getNext());
    
    currentNode.setNext(node);
    if (currentNode == this.tail) {
      this.tail = node;
    }
  }
  
  public void insertLast(T data)
  {
    insertLastNode(new LinkedListNode<T>(data));
  }
  
  public void insertLastNode(LinkedListNode<T> node)
  {
    if (isEmpty())
    {
      this.head = node;
      this.tail = node;
    }
    else
    {
      this.tail.setNext(node);
      
      this.tail = node;
    }
  }
  
  public void deleteFirst()
  {
    if (!isEmpty()) {
      this.head = this.head.getNext();
    }
    if (isEmpty()) {
      this.tail = null;
    }
    if ((!isEmpty()) && (this.head.getNext() == null)) {
      this.tail = this.head;
    }
  }
  
  public void deleteLast()
  {
    if (this.head == this.tail)
    {
      this.head = null;
      this.tail = null;
    }
    else if (!isEmpty())
    {
      LinkedListNode<T> currentNode = this.head;
      while (currentNode.getNext() != this.tail) {
        currentNode = currentNode.getNext();
      }
      deleteNext(currentNode);
    }
  }
  
  public void deleteNext(LinkedListNode<T> currentNode)
  {
    if (currentNode != this.tail)
    {
      if (currentNode.getNext() == this.tail) {
        this.tail = currentNode;
      }
      currentNode.setNext(currentNode.getNext().getNext());
    }
  }
  
  public int size()
  {
    LinkedListNode<T> currentNode = this.head;
    
    int size = 0;
    while (currentNode != null)
    {
      size++;
      
      currentNode = currentNode.getNext();
    }
    return size;
  }
  
  public boolean isEmpty()
  {
    return this.head == null;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "empty list";
    }
    LinkedListNode<T> currentNode = this.head;
    
    String listString = currentNode.toString();
    
    currentNode = currentNode.getNext();
    while (currentNode != null)
    {
      listString = listString + " -> " + currentNode.toString();
      
      currentNode = currentNode.getNext();
    }
    return listString;
  }
}
