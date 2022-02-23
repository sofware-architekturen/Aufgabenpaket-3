package view;

import java.util.ArrayList;
import java.util.List;

import interfaces.Observer;
import model.Ticker;

public class ViewObserver extends JTickerDisplay implements Observer<Ticker>{
    List<Observer<JTickerDisplay>> observers = new ArrayList<>();

    @Override
    public void update(Ticker t) {
        setDisplay(t.getValue());        
    }
    
}
