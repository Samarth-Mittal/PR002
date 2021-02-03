package model.colours;

import model.Observable;
import model.Observer;

import java.util.HashSet;
import java.util.Set;

public class Black extends Colour implements Observable {

    private Set<Observer> observers=new HashSet<>();
    private static final Black INSTANCE=new Black();

    private Black(){ }

    public static Black getInstance(){
        return INSTANCE;
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void post(){
        for(Observer observer: observers){
            observer.onUpdate(this);
        }
    }
}
