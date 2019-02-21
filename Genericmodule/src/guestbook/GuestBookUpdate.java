package guestbook;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;

@Adress("/guestbook/update")
@Type("URL")
public class GuestBookUpdate implements Service {
    public GuestBookUpdate() {
    }

    @Override
    public void execute(Request request, Response response) {
        //List<HashMap<String, String>> s=Collections.singletonList(request.getParsedData());
        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
       GuestBookDB guestBookDB =new GuestBookDB();
       guestBookDB.addCustomer("Joel");


        System.out.println("Running Guestbook");
        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/html");
        response.setBody(String.valueOf("Hej"));
        response.setContentLength(response.getBody().length());
        response.setStaticFile(false);

    }

    @Override
    public String toString() {
        return "GuestBookUpdate";
    }
}