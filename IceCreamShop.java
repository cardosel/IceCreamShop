import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IceCreamShop
  extends JPanel
{
  public static final int CORRECT_MATCH_SCORE = 10;
  public static final int INCORRECT_MATCH_SCORE = 5;
  public static final String INSTRUCTIONS = "<html>Make ice cream cones to match the next order (at the top).<br>Every correct order served earns you 10 points.<br>Make the wrong cone and you'll lose 5 points.</html>";
  private IceCreamLine line;
  private IceCreamMaker maker;
  private int score;
  private JLabel scoreLabel;
  
  public IceCreamShop()
  {
    super(new BorderLayout());
    
    addOrderArea();
    
    this.maker = new IceCreamMaker();
    add(this.maker, "Center");
    
    addControls();
    
    this.score = 0;
  }
  
  private void addOrderArea()
  {
    JPanel orderArea = new JPanel(new BorderLayout());
    
    orderArea.add(createNewOrderButton(), "South");
    
    this.line = new IceCreamLine();
    
    orderArea.add(this.line, "Center");
    
    add(orderArea, "West");
  }
  
  private void addControls()
  {
    JPanel topPanel = new JPanel(new GridLayout(2, 1));
    
    JPanel statusPanel = new JPanel(new GridLayout(2, 1));
    statusPanel.add(new JLabel("<html>Make ice cream cones to match the next order (at the top).<br>Every correct order served earns you 10 points.<br>Make the wrong cone and you'll lose 5 points.</html>"));
    this.scoreLabel = new JLabel("Score: 0");
    statusPanel.add(this.scoreLabel);
    topPanel.add(statusPanel);
    
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
        IceCreamShop.this.line.addRandomOrder();
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
        IceCreamShop.this.serve();
      }
    });
    return removeNextBtn;
  }
  
  public void serve()
  {
    if (this.line.hasOrder())
    {
      IceCreamCone nextOrder = this.line.getNextOrder();
      
      IceCreamCone madeCone = this.maker.getCone();
      if (matches(nextOrder, madeCone)) {
        this.score += 10;
      } else {
        this.score -= 5;
      }
      this.scoreLabel.setText("Score: " + Integer.toString(this.score));
      
      this.maker.reset();
    }
  }
  
  public boolean matches(IceCreamCone c1, IceCreamCone c2)
  {
    while (c1.hasScoop())
    {
      if (!c2.hasScoop()) {
        return false;
      }
      if (!c1.popTopScoop().equals(c2.popTopScoop())) {
        return false;
      }
    }
    return !c2.hasScoop();
  }
}
