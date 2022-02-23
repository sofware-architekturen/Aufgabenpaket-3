package controller;

import model.Ticker;
import view.JTickerDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TickerController implements ActionListener{   
    private Ticker ticker;

    public TickerController(Ticker ticker, JTickerDisplay display) {
        this.ticker = ticker;        

        ticker.register(display);

        display.registerActionListenerOnResetButton(this);
        display.registerActionListenerOnStartButton(this);
        display.registerActionListenerOnStopButton(this);
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
