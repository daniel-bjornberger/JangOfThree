package requestPackage;

import HttpServer.ServerConnect;

import java.util.Observable;
import java.util.Observer;

public class RequestObserver implements Observer {
    private Observable observable;
    public void setObservable(Observable observable){
        this.observable = observable;
        this.observable.addObserver(this);
        System.out.println("Request kopplad 1");
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ServerConnect){
            System.out.println("DET FUNKAR");
            System.out.println("=========================================");
            System.out.println(((ServerConnect) o).getRequestString());
            System.out.println("=========================================");
        }
    }
}
