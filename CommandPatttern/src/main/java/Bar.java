import java.util.ArrayList;
import java.util.List;

abstract public class Bar implements BarObserver{
    private List<BarObserver> observers;

    public abstract boolean isHappyHour();
    public abstract void startHappyHour();
    public abstract void endHappyHour();
    public Bar(){
        this.observers=new ArrayList<>();
    }
    public void addObserver(BarObserver observer) {
        this.observers.add(observer);
    }
    public void removeObserver(BarObserver observer) {
        this.observers.remove(observer);
    }
    public void notifyObservers() {
        if (observers.size() > 0) {
            for (BarObserver observer : observers)
                if (isHappyHour()) observer.happyHourStarted(this);
                else observer.happyHourEnded(this);
        }
    }

}
