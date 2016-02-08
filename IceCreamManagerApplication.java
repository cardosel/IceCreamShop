import javax.swing.JFrame;

public class IceCreamManagerApplication
{
  public static void main(String[] args)
  {
    JFrame iceFrame = new JFrame("Ice cream line");
    
    iceFrame.setSize(400, 600);
    
    iceFrame.add(new IceCreamLineManager());
    
    iceFrame.setDefaultCloseOperation(3);
    
    iceFrame.setVisible(true);
  }
}
