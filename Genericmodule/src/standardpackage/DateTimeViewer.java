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
@Adress("/date_time_viewer")
@Type("URL")
public class DateTimeViewer implements Service {


    @Override
    public void execute(Request request, Response response) {

        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/html");
        response.setBody("datetimeinput.html");
        response.setContentLength((int)(new File(new File("."),response.getBody()).length()));
        response.setStaticFile(true);

    }


    @Override
    public String toString() {
        return "DateTimeViewer";
    }

}
