package loadservices;

import requestpackage.Request;
import responsepackage.Response;

public interface Service {

    public void execute(Request request, Response response);
}
