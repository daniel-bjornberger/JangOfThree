package requestpackage;

import httpserver.ServerConnect;
import loadservices.Adress;
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
            String fileType =staticFileHandler.detect(request);
                    System.out.println( fileType + " file requested.");
            switch (fileType){
                case "html":

                    response.setDate();
            }
                return  response;
            }
            if(request.isValid()){
                System.out.println("No static file requested.");
                ServiceHandler serviceHandler = new ServiceHandler("out/artifacts/lib/");
                System.out.println("Services found: "+ serviceHandler.toString());
                System.out.println("REQUEST URL IS: " + request.getUrl());
                if (serviceHandler.getServices() != null){
                    for(Service service:serviceHandler.getServices()){
                        if (service.getClass().getAnnotation(Adress.class).value().equals(request.getUrl()))
                        service.execute(request, response);
                    }
                }
            }


    return response;
    }

}
