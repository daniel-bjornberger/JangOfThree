package loadservices;

import requestpackage.Request;
import responsepackage.Response;

public interface Service {

    //TODO: Add inparameters "request" & "result"
    public void execute(Request request, Response response);
}
