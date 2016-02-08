import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class IceCreamCone
  extends JComponent
{
  public static final String[] FLAVORS = { "vanilla", "strawberry", "green tea", "burnt caramel" };
  public static final Color[] PAINT_COLORS = { Color.WHITE, Color.PINK, new Color(204, 230, 202), new Color(230, 183, 117) };
  public static final int CONE_WIDTH = 40;
  public static final int CONE_HEIGHT = 70;
  public static final int SCOOP_DIAMETER = 60;
  public static final int SCOOP_OVERLAP = 10;
  public static final int RANDOM_MAX_SCOOPS = 4;
  private Stack<Integer> scoopFlavorStack;
  private double scale;
  
  public IceCreamCone()
  {
    this.scoopFlavorStack = new StackLL<Integer>();
    
    this.scale = 1.0D;
  }
  
  public void setScale(double s)
  {
    this.scale = s;
  }
  
  public void addScoop(String flavor)
  {
    this.scoopFlavorStack.push(new Integer(findFlavorIndex(flavor)));
  }
  
  public void addScoop()
  {
    addScoop(FLAVORS[((int)Math.floor(Math.random() * FLAVORS.length))]);
  }
  
  public boolean hasScoop()
  {
    return !this.scoopFlavorStack.empty();
  }
  
  public String popTopScoop()
  {
    if (this.scoopFlavorStack.empty()) {
      return "none";
    }
    return FLAVORS[((Integer)this.scoopFlavorStack.pop()).intValue()];
  }
  
  private int findFlavorIndex(String flavor)
  {
    if (flavor.toLowerCase().equals("none")) {
      return -1;
    }
    for (int i = 0; i < FLAVORS.length; i++) {
      if (flavor.toLowerCase().equals(FLAVORS[i])) {
        return i;
      }
    }
    return -1;
  }
  
  public void paint(Graphics g)
  {
    paintCone(g);
    
    paintScoops(g);
  }
  
  private void paintScoops(Graphics g)
  {
    int currentX = getWidth() / 2 - (int)Math.round(this.scale * 60.0D / 2.0D);
    
    int currentY = getHeight() - (int)Math.round(this.scale * 70.0D) - 
      (int)Math.round(this.scale * 60.0D) + (int)Math.round(this.scale * 10.0D);
    
    Stack<Integer> scoopsUpsideDown = new StackLL<Integer>();
    while (!this.scoopFlavorStack.empty()) {
      scoopsUpsideDown.push((Integer)this.scoopFlavorStack.pop());
    }
    while (!scoopsUpsideDown.empty())
    {
      Integer currentFlavorIndex = (Integer)scoopsUpsideDown.pop();
      
      paintScoop(g, currentFlavorIndex.intValue(), currentX, currentY);
      
      this.scoopFlavorStack.push(currentFlavorIndex);
      
      currentY = currentY - (int)Math.round(this.scale * 60.0D) + (int)Math.round(this.scale * 10.0D);
    }
  }
  
  public void paintCone(Graphics g)
  {
    int[] xPoints = new int[3];
    int[] yPoints = new int[3];
    
    xPoints[0] = (getWidth() / 2);
    yPoints[0] = getHeight();
    
    xPoints[1] = (xPoints[0] - (int)Math.round(this.scale * 40.0D / 2.0D));
    yPoints[1] = (yPoints[0] - (int)Math.round(this.scale * 70.0D));
    
    xPoints[2] = (xPoints[0] + (int)Math.round(this.scale * 40.0D / 2.0D));
    yPoints[2] = (yPoints[0] - (int)Math.round(this.scale * 70.0D));
    
    g.setColor(new Color(232, 208, 169));
    
    g.fillPolygon(xPoints, yPoints, 3);
  }
  
  public void paintScoop(Graphics g, int flavorIndex, int x, int y)
  {
    if (flavorIndex != -1)
    {
      g.setColor(PAINT_COLORS[flavorIndex]);
      
      g.fillOval(x, y, (int)Math.round(this.scale * 60.0D), (int)Math.round(this.scale * 60.0D));
    }
  }
  
  public static IceCreamCone createRandom()
  {
    IceCreamCone c = new IceCreamCone();
    
    int numScoops = 1 + (int)Math.floor(Math.random() * 3.0D);
    for (int i = 0; i < numScoops; i++) {
      c.addScoop();
    }
    return c;
  }
}
