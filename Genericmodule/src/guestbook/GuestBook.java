package guestbook;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;

import java.io.File;

@Adress("/guestbook")
@Type("URL")
public class GuestBook implements Service {
    @Override
    public void execute(Request request, Response response) {
        System.out.println("Running Guestbook");
        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/html");
        response.setBody("guestbook.html");
        response.setContentLength((int)(new File(new File("."),response.getBody()).length()));
        response.setStaticFile(true);
    }

    @Override
    public String toString() {
        return "GuestBook";
    }
}

