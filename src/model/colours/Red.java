package model.colours;

import model.Observable;
import model.Observer;

import java.util.HashSet;
import java.util.Set;

public class Red extends Colour implements Observable {

    private Set<Observer> observers=new HashSet<>();
    private static final Red INSTANCE=new Red();

    private Red(){ }

    public static Red getInstance(){
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

    public void post(){
        for(Observer observer: observers){
            observer.onUpdate(this);
        }
    }
}
