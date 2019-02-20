package genericpackage;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

/**
 * @author Pontus Fredriksson
 */

@Adress("/genericmoduleclass")
@Type ("URL")
public class GenericModuleClass implements Service {


    @Override
    public void execute(Request request, Response response) {
        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/plain");
        response.setBody("GenericModule funkar");
        response.setContentLength(response.getBody().length());
    }

    @Override
    public String toString() {
        return "GenericModuleClass";
    }
}
