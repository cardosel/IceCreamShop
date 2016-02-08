import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class IceCreamMaker
  extends JPanel
  implements ActionListener
{
  private IceCreamCone cone;
  private JButton[] flavorBtns;
  
  public IceCreamMaker()
  {
    super(new BorderLayout());
    
    this.cone = new IceCreamCone();
    add(this.cone, "Center");
    
    addMenu();
  }
  
  private void addMenu()
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    JPanel topPanel = new JPanel(new GridLayout(2, 1));
    topPanel.add(createFlavorMenu());
    
    topPanel.add(createTrashButton());
    
    add(topPanel, "North");
  }
  
  private JPanel createFlavorMenu()
  {
    JPanel menuPanel = new JPanel(new GridLayout(1, IceCreamCone.FLAVORS.length));
    
    this.flavorBtns = new JButton[IceCreamCone.FLAVORS.length];
    for (int i = 0; i < IceCreamCone.FLAVORS.length; i++)
    {
      this.flavorBtns[i] = new JButton(IceCreamCone.FLAVORS[i]);
      
      this.flavorBtns[i].setBackground(IceCreamCone.PAINT_COLORS[i]);
      
      this.flavorBtns[i].addActionListener(this);
      
      menuPanel.add(this.flavorBtns[i]);
    }
    return menuPanel;
  }
  
  private JButton createTrashButton()
  {
    JButton trashBtn = new JButton("Trash the top scoop!");
    trashBtn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        IceCreamMaker.this.cone.popTopScoop();
        
        IceCreamMaker.this.cone.repaint();
      }
    });
    return trashBtn;
  }
  
  public IceCreamCone getCone()
  {
    return this.cone;
  }
  
  public void reset()
  {
    while (this.cone.hasScoop()) {
      this.cone.popTopScoop();
    }
    this.cone.repaint();
  }
  
  public void actionPerformed(ActionEvent e)
  {
    for (int i = 0; i < this.flavorBtns.length; i++) {
      if (e.getSource() == this.flavorBtns[i]) {
        this.cone.addScoop(IceCreamCone.FLAVORS[i]);
      }
    }
    this.cone.repaint();
  }




}
