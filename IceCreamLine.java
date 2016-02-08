import javax.swing.Box;

@SuppressWarnings("serial")
public class IceCreamLine
  extends Box
{
  private Queue<IceCreamCone> orderLine;
  
  public IceCreamLine()
  {
    super(1);
    
    this.orderLine = new QueueLL<IceCreamCone>();
  }
  
  public boolean hasOrder()
  {
    return !this.orderLine.empty();
  }
  
  public void addOrder(IceCreamCone cone)
  {
    cone.setScale(0.5D);
    
    this.orderLine.enqueue(cone);
    
    add(cone);
    
    validate();
    repaint();
  }
  
  public void addRandomOrder()
  {
    addOrder(IceCreamCone.createRandom());
  }
  
  public IceCreamCone getNextOrder()
  {
    IceCreamCone nextOrder = (IceCreamCone)this.orderLine.dequeue();
    if (nextOrder != null)
    {
      remove(nextOrder);
      
      validate();
      repaint();
    }
    return nextOrder;
  }
}
