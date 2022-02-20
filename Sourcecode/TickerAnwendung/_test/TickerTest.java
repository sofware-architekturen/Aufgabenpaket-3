package _test;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Console;
import model.Ticker;
import view.JTickerDisplay;

// Test- und Steuerprogramm für den Ticker
// Oldstyle-Steuerung über Konsolenbefehle
public class TickerTest
{

  public static void main(String[] args) throws Exception
  {
    JTickerDisplay display = new JTickerDisplay();
    display.registerActionListenerOnStartButton( new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e)
      {
       System.out.println("Start-Button pushes");
      }
    });
    
    display.registerActionListenerOnStopButton( new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e)
      {
       System.out.println("Stop-Button pushes");
      }
    });
    
    display.registerActionListenerOnResetButton( new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e)
      {
       System.out.println("Reset-Button pushes");
      }
    });
    
    Ticker ticker = new Ticker();
    
    while( true )
    {
      String input = Console.read();
      if( input.equalsIgnoreCase("start")  )
      {
        ticker.start();
      }
      else if( input.equalsIgnoreCase("stop")  )
      {
        ticker.stop();
      }
      else if( input.equalsIgnoreCase("show")  )
      {
        display.setDisplay( ticker.getValue() );
      }
      else if( input.equalsIgnoreCase("reset")  )
      {
        ticker.reset();
      }
      else if( input.equalsIgnoreCase("exit")  )
      {
        ticker.stop();
        break;
      }
      else if( input.equalsIgnoreCase("help")  )
      {
        System.out.println("Folgende Kommandos werder unterstützt: ");
        System.out.println(" start - Startet den Ticker ");
        System.out.println(" stop - Stoppt den Ticker ");
        System.out.println(" reset - Setzt den Ticker zurück ");
        System.out.println(" show - Zeigt den aktuellen Status des Ticker im Display");
        System.out.println(" exit - beendet die Anwendung ");
      }
      else
      {
        System.out.println("Unbekanntes Kommando! ");
        System.out.println("-> Einhabe von help listet alle Kommandos auf ");
      }
    }
    
    System.out.println("done");
    display.dispose();
  }
}
