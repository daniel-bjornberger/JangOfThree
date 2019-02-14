package responsePackage;

import java.util.Arrays;

/**
 * @author Daniel Björnberger
 */
public class ResponseObject implements Response {


    private String version;

    private String status;

    private String statusMessage;

    private String date;

    private String server;

    private String[] contentType;

    private int contentLength;

    private String[] contentLanguage;

    private String connection;

    private String body;


    private static final String[] EMPTY_ARRAY = new String[0];

    private static final String EMPTY_STRING = "";




    public ResponseObject() {

        version = EMPTY_STRING;
        status = EMPTY_STRING;
        statusMessage = EMPTY_STRING;
        date = EMPTY_STRING;
        server = EMPTY_STRING;
        contentType = EMPTY_ARRAY;
        contentLength = 0;
        contentLanguage = EMPTY_ARRAY;
        connection = EMPTY_STRING;
        body = EMPTY_STRING;

    }




    @Override
    public String getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatusMessage() {
        return this.statusMessage;
    }

    @Override
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getServer() {
        return this.server;
    }

    @Override
    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public String[] getContentType() {
        return this.contentType;
    }

    @Override
    public void setContentType(String[] contentType) {
        this.contentType = contentType;
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
    public String[] getContentLanguage() {
        return this.contentLanguage;
    }

    @Override
    public void setContentLanguage(String[] contentLanguage) {
        this.contentLanguage = contentLanguage;
    }

    @Override
    public String getConnection() {
        return this.connection;
    }

    @Override
    public void setConnection(String connection) {
        this.connection = connection;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }



    /** The method 'toString' is only for testing purpose.
     * @return The method returns a String representation of a RequestObject.
     */
    @Override
    public String toString() {

        return  "Version: " +
                this.version +
                "\nStatus: " +
                this.status +
                "\nStatus Message: " +
                this.statusMessage +
                "\nDate: " +
                this.date +
                "\nServer: " +
                this.server +
                "\nContent-Type: " +
                Arrays.toString(this.contentType) +
                "\nContent-Length: " +
                this.contentLength +
                "\nContent-Language: " +
                Arrays.toString(this.contentLanguage) +
                "\nConnection: " +
                this.connection +
                "\nBody: " +
                this.body;
                       
    }

}
