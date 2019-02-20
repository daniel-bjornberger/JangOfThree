package genericpackage;

import loadservices.Adress;
import loadservices.Service;
import loadservices.ServiceHandler;
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
        ServiceHandler serviceHandler = new ServiceHandler("out/artifacts/lib/");
        String currentClass;

        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/plain");

        StringBuilder stringBuilder = new StringBuilder();
        for(Service service:serviceHandler.getServices()) {
            if (service.getClass().getAnnotation(Type.class).value().equals("URL")) {
                currentClass =(service.getClass().getAnnotation(Adress.class).value());
                System.out.println("KLASSER SOM LADDATS IN:" +currentClass);

                stringBuilder.append(
                        "<p>Click <a href=\"http://localhost:8082"+currentClass+ "\">here</a> to go to "+currentClass+".</p>"
                );
            }
        }
        response.setBody(

               // "<p>Click <a href=\"http://www.yahoo.com\">here</a> to go to yahoo.</p>"
               // "<p>Click <a href=\"http://www.yahoo.com\">here</a> to go to yahoo.</p>"



                stringBuilder.toString()

        );
        response.setContentLength(response.getBody().length());
    }

    @Override
    public String toString() {
        return "GenericModuleClass";
    }
}
