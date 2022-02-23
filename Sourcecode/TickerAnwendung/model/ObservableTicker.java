package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import interfaces.Observable;
import interfaces.Observer;

public class ObservableTicker extends Ticker implements Observable<Ticker>{

    private List<Observer<Ticker>> observers = new ArrayList<>();
    @Override
    public void register(Observer<Ticker> observer) {
        if(observers.contains(observer) == false){
            observers.add(observer);
        }
        
    }

    @Override
    public void remove(Observer<Ticker> observer) {
        observers.remove(observer);
        
    }

    @Override
    public void notifyObservers(Ticker ticker) {
        for(var o : observers){
            o.update(ticker);
        }
    }

    @Override
    public void start() {
        if( this.workerThread != null && this.workerThread.isAlive() )
      return;
    
    this.workerThread = new Thread(new Runnable() {

      @Override
      public void run()
      {
        try
        {
          while (ObservableTicker.this.workerThread.isInterrupted() == false )
          {
            ObservableTicker.this.counter.incrementAndGet();
            notifyObservers(ObservableTicker.this);
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

    @Override
    public void reset() {        
        super.reset();
        notifyObservers(ObservableTicker.this);
    }

    @Override
    public void stop() {        
        super.stop();
        notifyObservers(ObservableTicker.this);
    }
    
}
