package responsePackage;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * @author Daniel Björnberger
 */
public class ResponseObject implements Response {


    private String protocolVersion;

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

        protocolVersion = "http/1.1";
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
    public String getProtocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
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
    public boolean statusIsSet() {
        return this.status.length() > 0;
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
    public boolean statusMessageIsSet() {
        return this.statusMessage.length() > 0;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public void setDate() {
        this.date = java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME.format(ZonedDateTime.now(ZoneOffset.UTC));
    }

    @Override
    public boolean dateIsSet() {
        return this.date.length() > 0;
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
    public boolean serverIsSet() {
        return this.server.length() > 0;
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
    public boolean contentTypeIsSet() {
        return this.contentType.length > 0;
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
    public String[] getContentLanguage() {
        return this.contentLanguage;
    }

    @Override
    public void setContentLanguage(String[] contentLanguage) {
        this.contentLanguage = contentLanguage;
    }

    @Override
    public boolean contentLanguageIsSet() {
        return this.contentLanguage.length > 0;
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
    public boolean connectionIsSet() {
        return this.connection.length() > 0;
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


    /** The method 'toString' is only for testing purpose.
     * @return The method returns a String representation of a RequestObject.
     */
    @Override
    public String toString() {

        return  "Version: " +
                this.protocolVersion +
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
