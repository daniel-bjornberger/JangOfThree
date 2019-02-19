package requestpackage;

import java.util.Arrays;

/**
 * @author Daniel Björnberger
 */
public class PostRequest extends RequestObject{


    private String contentType;

    private int contentLength;

    private String body;


    public PostRequest() {

        super();

        contentType = RequestObject.EMPTY_STRING;
        contentLength = 0;
        body = RequestObject.EMPTY_STRING;

    }








    @Override
    public String getContentType() {
        return this.contentType;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public boolean contentTypeIsSet() {
        return this.contentType.length() > 0;
    }

    @Override
    public int getContentLength() {
        return this.contentLength;
    }

    @Override
    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    @Override
    public boolean contentLengthIsSet() {
        return this.contentLength > 0;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean bodyIsSet() {
        return this.body.length() > 0;
    }



    @Override
    public void setParsedData() {

        this.setBaseUrl(this.getFullUrl());

        if (this.bodyIsSet()) {

            String[] data = this.getBody().split("=&");

            for (int i = 0; i < data.length; i += 2) {

                this.getParsedData().put(data[i], data[i + 1]);

            }

        }

    }








    /** The method 'toString' is only for testing purpose.
            * @return The method returns a String representation of a RequestObject.
     */
    @Override
    public String toString() {

        return  "Method: POST" +
                "\nUrl: " +
                this.getFullUrl() +
                "\nProtocol Version: " +
                this.getProtocolVersion() +
                "\nHost: " +
                this.getHost() +
                "\nAccept: " +
                Arrays.toString(this.getAccept()) +
                "\nAccept-Language: " +
                Arrays.toString(this.getAcceptLanguage()) +
                "\nAccept-Charset: " +
                Arrays.toString(this.getAcceptCharset()) +
                "\nAccept-Encoding: " +
                Arrays.toString(this.getAcceptEncoding()) +
                "\nConnection: " +
                this.getConnection() +
                "\nContent-Type: " +
                this.contentType +
                "\nContent-Length: " +
                this .contentLength +
                "\nBody: " +
                this.body +
                "\nValid: " +
                this.isValid();

    }


}
