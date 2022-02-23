package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Ticker;

public class TickerController implements ActionListener{
    
    private Ticker ticker;

    public TickerController(Ticker ticker) {
        this.ticker = ticker;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equalsIgnoreCase("start")){
            ticker.start();
        }
        if(event.getActionCommand().equalsIgnoreCase("stop")){
            ticker.stop();
        }
        if(event.getActionCommand().equalsIgnoreCase("reset")){
            ticker.reset();
        }
        
    }
    
}
