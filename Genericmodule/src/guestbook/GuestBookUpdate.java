package guestbook;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;

import java.io.File;

@Adress("/guestbook/update")
@Type("URL")
public class GuestBookUpdate implements Service {
    @Override
    public void execute(Request request, Response response) {
        System.out.println("Running Guestbook");
        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/html");
        response.setBody("Skicka retur med jsson");
        response.setContentLength(response.getBody().length());

    }

    @Override
    public String toString() {
        return "GuestBook";
    }
}