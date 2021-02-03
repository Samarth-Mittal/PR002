package model.items;

import model.Observable;
import model.Observer;
import model.colours.Green;
import model.colours.Red;

public class Apple extends Items implements Observer {

    private static final Apple INSTANCE = new Apple();

    private Apple(){}

    public static Apple getInstance(){
        return INSTANCE;
    }

    @Override
    public void subscribes() {
        Green.getInstance().subscribe(this);
        Red.getInstance().subscribe(this);
    }

    @Override
    public void unsubscribes(){
        Green.getInstance().unsubscribe(this);
        Red.getInstance().unsubscribe(this);
    }

    @Override
    public void onUpdate(Observable observable) {
        String reply = String.format("I'm %s! I'm sometimes %s.", this.getClass().getSimpleName(), observable.getClass().getSimpleName());
        System.out.println(reply);
    }
}
