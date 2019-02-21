package genericpackage;

import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;

import java.io.File;

@Type("standard")
public class FileNotFound implements Service {
    public void execute(Request request, Response response) {

        if (!response.contentTypeIsSet()
               // ||
                //(response.isStaticFile()
                //&& (!new File(request.getFullUrl()).isFile()                       )
                //)
        ){
            System.out.println("Running FileNotFound module...");
            response.setStatus("200");
            response.setStatusMessage("OK");
            response.setContentType("text/html");
            response.setBody("404.jpg");
            response.setContentLength((int)(new File(new File("."),response.getBody()).length()));
            response.setStaticFile(true);
        }
    }

}
