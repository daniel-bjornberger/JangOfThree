package guestbook;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;

import java.io.File;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

@Adress("/json")
@Type("URL")

public class Returnjson implements Service {

    @Override
    public void execute(Request request, Response response) {

        String firstname=request.getParsedData().get("firstname");
        String messeges=request.getParsedData().get("messeges");


        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/html");
        response.setBody(String.valueOf("Hej"));
        response.setContentLength(response.getBody().length());
        response.setStaticFile(false);
    }


    @Override
    public String toString() {
        return "GenericModuleClass";
        }
}





