package genericpackage;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;

import java.io.File;

@Adress("/alert")
@Type("script")
public class Alert implements Service {
    @Override
    public void execute(Request request, Response response) {
        System.out.println("Running Alert module...");
        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/javascript");
        response.setBody("test.js");
        response.setContentLength((int) (new File(new File("."), response.getBody()).length()));
        response.setStaticFile(true);

    }

    @Override
    public String toString() {
        return "GenericModuleClass";
    }
}