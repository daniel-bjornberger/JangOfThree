package genericpackage;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;
@Adress("/")
@Type("URL")
public class Index implements Service {
    @Override
    public void execute(Request request, Response response) {
        response.setStatus("200");
        response.setStatusMessage("OK");
        response.setContentType("text/htlm");
        response.setBody("index.htlm");
        response.setContentLength(response.getBody().length());
    }

    @Override
    public String toString() {
        return "GenericModuleClass";
    }
}

