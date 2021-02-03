package model.items;

import model.Observable;
import model.Observer;
import model.colours.Green;
import model.colours.Yellow;

public class Banana extends Items implements Observer {

    private static final Banana INSTANCE = new Banana();

    private Banana(){}

    public static Banana getInstance(){
        return INSTANCE;
    }

    @Override
    public void subscribes() {
        Green.getInstance().subscribe(this);
        Yellow.getInstance().subscribe(this);
    }

    @Override
    public void unsubscribes(){
        Green.getInstance().unsubscribe(this);
        Yellow.getInstance().unsubscribe(this);
    }

    @Override
    public void onUpdate(Observable observable) {
        String reply = String.format("I'm %s! I'm sometimes %s.", this.getClass().getSimpleName(), observable.getClass().getSimpleName());
        System.out.println(reply);
    }
}
