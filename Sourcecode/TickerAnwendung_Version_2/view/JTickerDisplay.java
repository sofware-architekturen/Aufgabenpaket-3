package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Ticker;
import observer.Observer;

public class JTickerDisplay extends JFrame implements Observer<Ticker>
{
  private static final long serialVersionUID = -631034923132906745L;
  
  private JTickerDisplayPanel counterPanel =new JTickerDisplayPanel();
  private JTickerButtonPanel  buttonPanel   = new JTickerButtonPanel();

  public JTickerDisplay()
  {
    super("Ticker");
   
    this.setLayout(new  BorderLayout(5, 5));
    this.add(counterPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.SOUTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    this.setAlwaysOnTop(true);
    this.setSize(205, 160);
    this.setResizable(false);
    this.pack();
    this.setVisible(true);
  }
  
  public void reset()
  {
    this.counterPanel.reset();
  }
  
  public void setDisplay(int value)
  {
    this.counterPanel.setDisplay(value);
  }
  
  public void registerActionListenerOnStartButton(ActionListener listener)
  {
    this.buttonPanel.getStartButton().addActionListener(listener);
  }
  
  public void registerActionListenerOnStopButton(ActionListener listener)
  {
    this.buttonPanel.getStopButton().addActionListener(listener);
  }
  
  public void registerActionListenerOnResetButton(ActionListener listener)
  {
    this.buttonPanel.getResetButton().addActionListener(listener);
  }

  @Override
  public void update(Ticker t) {
   setDisplay(t.getValue());    
  }
}
