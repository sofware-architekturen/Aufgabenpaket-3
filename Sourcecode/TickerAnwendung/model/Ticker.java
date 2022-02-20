package model;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Die Klasse realisiert einen Ticker, der alle 100 Millisekunden seinen internen
// Zähler hochzählt.
// Das Zählen kann gestartet und gestoppt werden. Weiter kann der interne
// Zähler zurückgesetzt werden
public class Ticker
{
  private AtomicInteger counter = new AtomicInteger(0);
  private Thread workerThread = null;

  public Ticker()
  {
    super();
  }

  public void start()
  {
    // Ignoriere start-Befehl, falls Thread noch läuft
    if( this.workerThread != null && this.workerThread.isAlive() )
      return;
    
    this.workerThread = new Thread(new Runnable() {

      @Override
      public void run()
      {
        try
        {
          while (Ticker.this.workerThread.isInterrupted() == false )
          {
            Ticker.this.counter.incrementAndGet();
            TimeUnit.MILLISECONDS.sleep(100);
          }
        }
        catch (InterruptedException exce)
        {
        }
      }
    });
    this.workerThread.start();
  }

  public void stop()
  {
    if (workerThread != null)
    {
      this.workerThread.interrupt();
    }
  }

  public void reset()
  {
    this.stop();
    this.counter.set(0);
  }
  
  public int getValue()
  {
    return this.counter.get();
  }
}
