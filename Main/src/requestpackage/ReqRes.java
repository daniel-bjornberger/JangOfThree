package requestpackage;

import responsepackage.Response;

public class ReqRes {
    Request request;
    Response response;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public ReqRes(Request request, Response response){
        this.request= request;
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
