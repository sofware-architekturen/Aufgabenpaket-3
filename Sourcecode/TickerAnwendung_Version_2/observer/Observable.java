package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T> {
    protected List<Observer<T>> observers = new ArrayList<>();
    public void register(Observer<T> observer){
        if(this.observers.contains(observer) == false){
            observers.add(observer);
        }
    }
    public void remove(Observer<T> observer){
        observers.remove(observer);
    }
    public void notifyObservers(T t){
        for(var observer : observers){
            observer.update(t);
        }
    }
    public void clean(){
        this.observers = new ArrayList<>();
    }

}
