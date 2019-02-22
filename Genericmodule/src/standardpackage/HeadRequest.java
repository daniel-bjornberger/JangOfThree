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
@Adress("/head_request_demo")
@Type("URL")
public class HeadRequest implements Service {

    @Override
    public void execute(Request request, Response response) {

        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/html");
        response.setBody("headajaxdemo.html");
        response.setContentLength((int)(new File(new File("."),response.getBody()).length()));
        response.setStaticFile(true);

    }

    @Override
    public String toString() {
        return "HeadRequest";
    }

}



