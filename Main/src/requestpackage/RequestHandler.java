package requestpackage;

import httpserver.ServerConnect;
import loadservices.Adress;
import loadservices.Service;
import loadservices.ServiceHandler;
import responsepackage.Response;
import responsepackage.ResponseObject;

import java.io.File;

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
                case ".html":
                    response.setStatus("200");
                    response.setStatusMessage("OK");
                    response.setContentType("text/html");
                    response.setBody(request.getFullUrl());
                    response.setContentLength(response.getBody().length());
                    request.setValid(false);
                    break;
                case ".css":
                    response.setStatus("200");
                    response.setStatusMessage("OK");
                    response.setContentType("text/css");
                    response.setBody(request.getFullUrl());
                    response.setContentLength(response.getBody().length());
                    request.setValid(false);
                    break;
                case ".js":
                    response.setStatus("200");
                    response.setStatusMessage("OK");
                    response.setContentType("text/javascript");
                    response.setBody(request.getFullUrl());
                    response.setContentLength(response.getBody().length());
                    request.setValid(false);
                    break;

                case ".pdf":
                    response.setStatus("200");
                    response.setStatusMessage("OK");
                    response.setContentType("application/pdf");
                    response.setBody(request.getFullUrl());
                    response.setContentLength(response.getBody().length());
                    request.setValid(false);
                    System.out.println("got to pdf switch");
                    break;
                case ".png":
                    response.setStatus("200");
                    response.setStatusMessage("OK");
                    response.setContentType("image/png");
                    response.setBody(request.getFullUrl());
                    response.setContentLength(response.getBody().length());
                    request.setValid(false);
                    break;
                case ".jpg":
                    response.setStatus("200");
                    response.setStatusMessage("OK");
                    response.setContentType("image/jpeg");
                    System.out.println("REQUEST FULL URL:"+ request.getFullUrl());
                    response.setBody(request.getFullUrl());
                    response.setContentLength(response.getBody().length());
                    request.setValid(false);
                    break;

            }
            response.setContentLength((int)(new File(new File("."),response.getBody()).length()));


            System.out.println(response);
                return  response;
            }
            if(request.isValid()){
                System.out.println("No static file requested.");
                ServiceHandler serviceHandler = new ServiceHandler("out/artifacts/lib/");
                System.out.println("Services found: "+ serviceHandler.toString());
                System.out.println("REQUEST URL IS: " + request.getFullUrl());
                if (serviceHandler.getServices() != null){
                    for(Service service:serviceHandler.getServices()){
                        if (service.getClass().getAnnotation(Adress.class).value().equals(request.getFullUrl()))
                        service.execute(request, response);
                    }
                }
            }


    return response;
    }

}
