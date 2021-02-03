package model.items;

import model.Observable;
import model.Observer;
import model.colours.Blue;
import model.colours.Yellow;

public class Frog extends Items implements Observer {

    private static final Frog INSTANCE = new Frog();

    private Frog(){}

    public static Frog getInstance(){
        return INSTANCE;
    }

    @Override
    public void subscribes() {
        Blue.getInstance().subscribe(this);
        Yellow.getInstance().subscribe(this);
    }

    @Override
    public void unsubscribes(){
        Blue.getInstance().unsubscribe(this);
        Yellow.getInstance().unsubscribe(this);
    }

    @Override
    public void onUpdate(Observable observable) {
        String reply = String.format("I'm %s! I'm %s today.", this.getClass().getSimpleName(), observable.getClass().getSimpleName());
        System.out.println(reply);
    }
}
