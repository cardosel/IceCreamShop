import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IceCreamLineManager
  extends JPanel
{
  private IceCreamLine line;
  
  public IceCreamLineManager()
  {
    super(new BorderLayout());
    
    this.line = new IceCreamLine();
    add(this.line, "Center");
    
    addControls();
  }
  
  private void addControls()
  {
    JPanel topPanel = new JPanel(new GridLayout(2, 1));
    topPanel.add(createNewOrderButton());
    topPanel.add(createRemoveNextButton());
    
    add(topPanel, "North");
  }
  
  private JButton createNewOrderButton()
  {
    JButton newOrderBtn = new JButton("Add a random order");
    newOrderBtn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        IceCreamLineManager.this.line.addRandomOrder();
      }
    });
    return newOrderBtn;
  }
  
  private JButton createRemoveNextButton()
  {
    JButton removeNextBtn = new JButton("Serve the next order");
    removeNextBtn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        IceCreamLineManager.this.line.getNextOrder();
      }
    });
    return removeNextBtn;
  }
}
