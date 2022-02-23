package _test;


import controller.Console;
import controller.TickerController;
import model.ObservableTicker;
import view.ViewObserver;

// Test- und Steuerprogramm f�r den Ticker
// Oldstyle-Steuerung �ber Konsolenbefehle
public class TickerTest
{

  public static void main(String[] args) throws Exception
  {
    ViewObserver display = new ViewObserver();
    ObservableTicker ticker = new ObservableTicker();
    TickerController tickerController = new TickerController(ticker);
    
    ticker.register(display);
    
    display.registerActionListenerOnStartButton(tickerController);
    display.registerActionListenerOnStopButton(tickerController);  
    display.registerActionListenerOnResetButton(tickerController);
    
    
    
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
        System.out.println("Folgende Kommandos werder unterst�tzt: ");
        System.out.println(" start - Startet den Ticker ");
        System.out.println(" stop - Stoppt den Ticker ");
        System.out.println(" reset - Setzt den Ticker zur�ck ");
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
