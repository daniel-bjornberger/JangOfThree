package standardpackage;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;
import java.io.File;

/**
 * @author Daniel Björnberger
 */
@Adress()
@Type("standard")
public class NotImplemented implements Service {

    @Override
    public void execute(Request request, Response response) {

        if (!request.isImplemented()) {

            response.setStatus("501");
            response.setStatusMessage("Not Implemented");
            response.setContentType("text/html");
            response.setBody("501.html");
            response.setContentLength((int)(new File(new File("."),response.getBody()).length()));
            response.setStaticFile(true);

        }

    }


}



