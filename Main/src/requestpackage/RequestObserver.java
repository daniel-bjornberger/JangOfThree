package requestpackage;

import httpserver.ServerConnect;
import loadservices.Service;
import loadservices.ServiceHandler;

import java.util.Observable;
import java.util.Observer;

/**
 * @authors Pontus Fredriksson, Joel Gunnarsson
 */
public class RequestObserver implements Observer {
    private static boolean addBody =false;
    private Observable observable;
    String requestString="";
    public void setObservable(Observable observable){
        this.observable = observable;
        this.observable.addObserver(this);
        System.out.println("Request kopplad 1");
    }
    @Override
    public void update(Observable o, Object arg) {
        Request request = new RequestObject();
        if (o instanceof ServerConnect){
            System.out.println("=========================================");

            requestString=((ServerConnect) o).getRequestString();
            System.out.println(((ServerConnect) o).getRequestString());
            System.out.println("=========================================");
            System.out.println("Creating Request object...");
            RequestFactory requestFactory = new RequestFactory();
            request = requestFactory.createRequestObject(requestString);
            System.out.println("Request object created successfully!");
            if (staticFileHandler.detect(request)!=null){
                System.out.println(staticFileHandler.detect(request) + " file requested.");
            }
            if(request.isValid()){
                System.out.println("No static file requested.");
                ServiceHandler serviceHandler = new ServiceHandler("out/artifacts/lib/");
                System.out.println("Services found: "+ serviceHandler.toString());

                if (serviceHandler.getServices() != null){
                    for(Service service:serviceHandler.getServices()){
                        // service.execute(request, );
                    }
                }
            }


        }
    }
}
