package model.items;

import model.Observable;
import model.Observer;
import model.colours.Black;
import model.colours.Red;

public class Ink extends Items implements Observer {

    private static final Ink INSTANCE = new Ink();

    private Ink(){}

    public static Ink getInstance(){
        return INSTANCE;
    }

    @Override
    public void subscribes() {
        Black.getInstance().subscribe(this);
        Red.getInstance().subscribe(this);
    }

    @Override
    public void unsubscribes(){
        Black.getInstance().unsubscribe(this);
        Red.getInstance().unsubscribe(this);
    }

    @Override
    public void onUpdate(Observable observable) {
        String reply = String.format("I'm %s! I'm sometimes %s.", this.getClass().getSimpleName(), observable.getClass().getSimpleName());
        System.out.println(reply);
    }
}
