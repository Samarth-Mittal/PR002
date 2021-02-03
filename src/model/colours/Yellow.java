package model.colours;

import model.Observable;
import model.Observer;

import java.util.HashSet;
import java.util.Set;

public class Yellow extends Colour implements Observable {

    private Set<Observer> observers=new HashSet<>();
    private static final Yellow INSTANCE=new Yellow();

    private Yellow(){ }

    public static Yellow getInstance(){
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
