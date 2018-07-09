package de.haw_hamburg.mt.p2.projekt.finnazad;

import java.util.Observable;

public class ObservableForms extends Observable {

    @Override
    public void notifyObservers(Object arg)
    {
    	
        setChanged();
        super.notifyObservers(arg);
    }
}
