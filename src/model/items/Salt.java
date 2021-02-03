package model.items;

import model.Observable;
import model.Observer;
import model.colours.White;

public class Salt extends Items implements Observer {

    private static final Salt INSTANCE = new Salt();

    private Salt(){}

    public static Salt getInstance(){
        return INSTANCE;
    }

    @Override
    public void subscribes() {
        White.getInstance().subscribe(this);
    }

    @Override
    public void unsubscribes(){
        White.getInstance().unsubscribe(this);
    }

    @Override
    public void onUpdate(Observable observable) {
        String reply = String.format("I'm %s! I'm sometimes %s.", this.getClass().getSimpleName(), observable.getClass().getSimpleName());
        System.out.println(reply);
    }
}
