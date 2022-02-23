package interfaces;

public interface Observable<T> {
    public void register(Observer<T> observer);
    public void remove(Observer<T> observer);
    public void notifyObservers(T data);
}
