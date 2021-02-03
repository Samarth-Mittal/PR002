package model.items;

import model.Observable;
import model.Observer;
import model.colours.Black;
import model.colours.Blue;
import model.colours.Green;
import model.colours.Red;

public class Sky extends Items implements Observer {

    private static final Sky INSTANCE = new Sky();

    private Sky(){}

    public static Sky getInstance(){
        return INSTANCE;
    }

    @Override
    public void subscribes() {
        Blue.getInstance().subscribe(this);
        Black.getInstance().subscribe(this);
    }

    @Override
    public void unsubscribes(){
        Blue.getInstance().unsubscribe(this);
        Black.getInstance().unsubscribe(this);
    }

    @Override
    public void onUpdate(Observable observable) {
        String reply = String.format("I'm %s! I'm sometimes %s.", this.getClass().getSimpleName(), observable.getClass().getSimpleName());
        System.out.println(reply);
    }
}
