package model.items;

import model.Observable;
import model.Observer;
import model.colours.Red;

public class Blood extends Items implements Observer {

    private static final Blood INSTANCE = new Blood();

    private Blood(){}

    public static Blood getInstance(){
        return INSTANCE;
    }

    @Override
    public void subscribes() {
        Red.getInstance().subscribe(this);
    }

    @Override
    public void unsubscribes(){
        Red.getInstance().unsubscribe(this);
    }

    @Override
    public void onUpdate(Observable observable) {
        String reply = String.format("I'm %s! I'm sometimes %s.", this.getClass().getSimpleName(), observable.getClass().getSimpleName());
        System.out.println(reply);
    }
}
