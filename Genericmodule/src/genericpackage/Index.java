package genericpackage;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;

import java.io.File;

@Adress("/")
@Type("URL")
public class Index implements Service {
    @Override
    public void execute(Request request, Response response) {
        System.out.println("Running Index module...");
        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/html");
        response.setBody("index.html");
        response.setContentLength((int)(new File(new File("."),response.getBody()).length()));
        response.setStaticFile(true);
    }

    @Override
    public String toString() {
        return "GenericModuleClass";
    }
}

