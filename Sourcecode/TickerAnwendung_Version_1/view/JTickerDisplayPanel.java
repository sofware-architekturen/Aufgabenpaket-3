package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;


import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Realisiert die vierstellige Digitalanzeige
class JTickerDisplayPanel extends JPanel
{
  private static final long serialVersionUID = 2336456773184808310L;
  private final  int digitMaxHight  = 70;
  private final  int digitMaxWidth = 50;
  private final Dimension size = new Dimension(4*this.digitMaxWidth, this.digitMaxHight);
  
  private JLabel digit0, digit1, digit2, digit3;
  private ImageIcon NULL, ONE, TWO,THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,NINE;
  
  public JTickerDisplayPanel()
  {
    super();
    this.initDigits();
    this.setSize(this.size);
    this.setPreferredSize( this.size );
    
    this.setLayout( new GridLayout(1, 4));
    
    this.digit0 = new JLabel( this.NULL );
    this.digit1 = new JLabel( this.NULL );
    this.digit2 = new JLabel( this.NULL );
    this.digit3 = new JLabel( this.NULL );
    
    this.add( this.digit3 );
    this.add( this.digit2 );
    this.add( this.digit1 );
    this.add( this.digit0 );
  }
  
  public void reset()
  {
    this.setDisplay(0);
  }
  
  
  
  public  void setDisplay(int value)
  {
    assert( value >= 0 );
    assert( value < 1000 );
    
    this.digit0.setIcon( getIcon(value%10 ) );
    this.digit1.setIcon( getIcon((value/10)%10 ) );
    this.digit2.setIcon( getIcon((value/100)%10 ) );
    this.digit3.setIcon( getIcon((value/1000)%10 ) );
    
    this.repaint();
  }
  
  
  private ImageIcon getIcon(int i)
  {
    assert( i >= 0 );
    assert( i < 10 );
    
    switch( i )
    {
    case 0 : return this.NULL;
    case 1 : return this.ONE;
    case 2 : return this.TWO;
    case 3 : return this.THREE;
    case 4 : return this.FOUR;
    case 5 : return this.FIVE;
    case 6 : return this.SIX;
    case 7 : return this.SEVEN;
    case 8 : return this.EIGHT;
    case 9 : return this.NINE;
    default: return null;
    }
  }
  
  private void initDigits()
  {
    int hight = this.digitMaxHight;
    int width = this.digitMaxWidth;
      
    this.NULL =   rescaleImage(new File("./resources/0.gif"), hight, width);
    this.ONE  =  rescaleImage(new File("./resources/1.gif"), hight, width);
    this.TWO =  rescaleImage(new File("./resources/2.gif"), hight, width);
    this.THREE =  rescaleImage(new File("./resources/3.gif"), hight, width);
    this.FOUR =  rescaleImage(new File("./resources/4.gif"), hight, width);
    this.FIVE = rescaleImage(new File("./resources/5.gif"), hight, width);
    this.SIX =  rescaleImage(new File("./resources/6.gif"), hight, width);
    this.SEVEN =  rescaleImage(new File("./resources/7.gif"), hight, width);
    this.EIGHT =  rescaleImage(new File("./resources/8.gif"), hight, width);
    this.NINE =  rescaleImage(new File("./resources/9.gif"), hight, width);
  }
  
  // Source:  http://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
  public ImageIcon rescaleImage(File source,int maxHeight, int maxWidth)
  {
      int newHeight = 0, newWidth = 0;        // Variables for the new height and width
      int priorHeight = 0, priorWidth = 0;
      BufferedImage image = null;
      ImageIcon sizeImage;

      try {
              image = ImageIO.read(source);        // get the image
      } catch (Exception e) {

              e.printStackTrace();
              System.out.println("Picture upload attempted & failed");
      }

      sizeImage = new ImageIcon(image);

      if(sizeImage != null)
      {
          priorHeight = sizeImage.getIconHeight(); 
          priorWidth = sizeImage.getIconWidth();
      }

      // Calculate the correct new height and width
      if((float)priorHeight/(float)priorWidth > (float)maxHeight/(float)maxWidth)
      {
          newHeight = maxHeight;
          newWidth = (int)(((float)priorWidth/(float)priorHeight)*(float)newHeight);
      }
      else 
      {
          newWidth = maxWidth;
          newHeight = (int)(((float)priorHeight/(float)priorWidth)*(float)newWidth);
      }


      // Resize the image

      // 1. Create a new Buffered Image and Graphic2D object
      BufferedImage resizedImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
      Graphics2D g2 = resizedImg.createGraphics();

      // 2. Use the Graphic object to draw a new image to the image in the buffer
      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

      g2.drawImage(image, 0, 0, newWidth, newHeight, Color.lightGray, null);
      g2.dispose();

      // 3. Convert the buffered image into an ImageIcon for return
      return (new ImageIcon(resizedImg));
  }
}
