import javax.swing.JFrame;

public class IceCreamMakerApplication
{
  public static void main(String[] args)
  {
    JFrame iceFrame = new JFrame("Ice cream cone maker");
    
    iceFrame.setSize(500, 600);
    
    iceFrame.add(new IceCreamMaker());
    
    iceFrame.setDefaultCloseOperation(3);
    
    iceFrame.setVisible(true);
  }
}
