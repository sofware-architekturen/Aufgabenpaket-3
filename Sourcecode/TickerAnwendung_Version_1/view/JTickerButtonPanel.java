package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

// Realisiert die Button-Zeile
public class JTickerButtonPanel extends JPanel
{
  private static final long serialVersionUID = 1060386597109405266L;
  
  private JButton startButton = new JButton("Start");
  private JButton stopButton = new JButton("Stop");
  private JButton resetButton = new JButton("Reset");

  public JTickerButtonPanel()
  {
    super();
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    this.add( this.startButton );
    this.add( this.stopButton );
    this.add( this.resetButton );
  }
  
  JButton getStartButton()
  {
    return this.startButton;
  }
  
  JButton getStopButton()
  {
    return this.stopButton;
  }
  
  JButton getResetButton()
  {
    return this.resetButton;
  }
}
