package model;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import observer.Observable;

// Die Klasse realisiert einen Ticker, der alle 100 Millisekunden seinen internen
// Z�hler hochz�hlt.
// Das Z�hlen kann gestartet und gestoppt werden. Weiter kann der interne
// Z�hler zur�ckgesetzt werden
public class Ticker extends Observable<Ticker>
{
  private AtomicInteger counter = new AtomicInteger(0);
  private Thread workerThread = null;

  public Ticker()
  {
    super();
  }

  public void start()
  {
    // Ignoriere start-Befehl, falls Thread noch l�uft
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
            notifyObservers(Ticker.this);
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
      notifyObservers(Ticker.this);
    }
  }

  public void reset()
  {
    this.stop();
    this.counter.set(0);
    notifyObservers(Ticker.this);
  }
  
  public int getValue()
  {
    return this.counter.get();
  }
}
