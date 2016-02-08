import java.io.PrintStream;

public class Palindrome
{
  public static void main(String[] args)
  {
    String testStr = "wasitacaroracatisaw";
    
    Queue<Integer> qint = new QueueLL();
    qint.enqueue(new Integer(3));
    qint.enqueue(new Integer(3));
    qint.enqueue(new Integer(6));
    qint.enqueue(new Integer(6));
    qint.enqueue(new Integer(8));
    
    LinkedList<String> l = new LinkedList();
    l.insertFirst("rwer");
    l.insertFirst("awr");
    System.out.println(toArray(l));
  }
  
  public static boolean isPal(String str)
  {
    StackLL<String> stack = new StackLL();
    QueueLL<String> queue = new QueueLL();
    for (int i = 0; i < str.length(); i++)
    {
      String s = str.charAt(i);
      queue.enqueue(s);
      stack.push(s);
    }
    while (!queue.empty()) {
      if (!((String)queue.dequeue()).equals(stack.pop())) {
        return false;
      }
    }
    return true;
  }
  
  public static int sizegood(Queue<Integer> q)
  {
    int size = 0;
    while (!q.empty())
    {
      q.dequeue();
      size++;
    }
    return size;
  }
  
  public static int size(Queue<Integer> q)
  {
    int size = 0;
    boolean isEmpty = q.empty();
    while (!isEmpty)
    {
      q.dequeue();
      size++;
    }
    return size;
  }
  
  public static String[] toArray(LinkedList<String> list)
  {
    int i = 0;
    String[] result = new String[list.size()];
    LinkedListNode<String> current = list.getFirstNode();
    while (current != null)
    {
      current = current.getNext();
      result[i] = ((String)current.getData());
      i++;
    }
    return result;
  }
}
