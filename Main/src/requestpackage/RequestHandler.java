package requestpackage;

import httpserver.ServerConnect;
import loadservices.Service;
import loadservices.ServiceHandler;
import responsepackage.Response;
import responsepackage.ResponseObject;

public class RequestHandler {
    private static boolean addBody =false;

    public Response doEverything(String requestString){

            System.out.println("=========================================");
            System.out.println("Creating Request object...");
            RequestFactory requestFactory = new RequestFactory();
            Request request = requestFactory.createRequestObject(requestString);
            System.out.println("Request object created successfully!");

            Response response = new ResponseObject();


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


    return response;
    }

}
