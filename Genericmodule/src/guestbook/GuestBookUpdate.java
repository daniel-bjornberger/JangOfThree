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

@Adress("/guestbook/update")
@Type("URL")
public class GuestBookUpdate implements Service {
    public GuestBookUpdate() {
    }

    @Override
    public void execute(Request request, Response response) {

        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
        System.out.println(request.getParsedData().size());
        String firstname=request.getParsedData().get("firstname");
        String messeges=request.getParsedData().get("messeges");
        messeges=messeges.replace("+"," ");
        byte[] ptext = messeges.getBytes(ISO_8859_1);
        messeges = new String(ptext, UTF_8);


        System.out.println(firstname);
        System.out.println(messeges);

        GuestBookDB guestBookDB =new GuestBookDB();
       guestBookDB.addVisitor(firstname,messeges);

        /*
        System.out.println("Running Guestbook");
        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/html");
        response.setBody(String.valueOf("Hej"));
        response.setContentLength(response.getBody().length());
        response.setStaticFile(false);
        */


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
        return "GuestBookUpdate";
    }
}