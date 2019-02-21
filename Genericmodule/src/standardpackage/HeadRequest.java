package standardpackage;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;
import java.io.File;


@Adress("/head")
@Type("Standard")
public class HeadRequest implements Service {

    @Override
    public void execute(Request request, Response response) {

        System.out.println("Running Head Request...");
        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/html");
        response.setBody("headajaxdemo.html");
        response.setContentLength((int)(new File(new File("."),response.getBody()).length()));
        response.setStaticFile(true);

        System.out.println(response.toString());

    }

    @Override
    public String toString() {
        return "HeadRequest";
    }

}



