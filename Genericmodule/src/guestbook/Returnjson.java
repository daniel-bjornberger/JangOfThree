package guestbook;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
        Gson gson = new Gson();
        String serialized = gson.toJson(request.getParsedData());


        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/html");
        response.setBody(String.valueOf(serialized));
        response.setContentLength(response.getBody().length());
        response.setStaticFile(false);
    }


    @Override
    public String toString() {
        return "GenericModuleClass";
        }
}





