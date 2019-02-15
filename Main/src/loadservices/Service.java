package loadservices;

import requestPackage.Request;
import responsePackage.Response;

public interface Service {

    //TODO: Add inparameters "request" & "result"
    public void execute(Request request, Response response);
}
