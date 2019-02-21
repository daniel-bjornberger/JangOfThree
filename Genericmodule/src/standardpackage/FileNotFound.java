package standardpackage;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;

import java.io.File;
@Adress()
@Type("standard")
public class FileNotFound implements Service {
    public void execute(Request request, Response response) {
        System.out.println("rep.body:"+response.getBody());
        System.out.println("IS FILE:"+new File(new File("http://localhost:8082"),response.getBody()).isFile());
        if (!response.contentTypeIsSet()
                ||
                (response.isStaticFile()
                && (!new File(new File("."),response.getBody()).isFile())
                )
        ){
            System.out.println("Running FileNotFound module...");
            response.setStatus("404");
            response.setStatusMessage("Not Found");
            response.setContentType("text/html");
            response.setBody("404.html");
            response.setContentLength((int)(new File(new File("."),response.getBody()).length()));
            response.setStaticFile(true);
        }
    }

}
