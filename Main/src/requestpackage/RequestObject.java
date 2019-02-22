package requestpackage;

import java.util.HashMap;

/**
 * @author Daniel Björnberger
 */
public abstract class RequestObject implements Request {


    private String fullUrl;

    private String baseUrl;

    private String protocolVersion;

    private String host;

    private String[] accept;

    private String[] acceptLanguage;

    private String[] acceptCharset;

    private String[] acceptEncoding;

    private String connection;

    private boolean valid;

    private HashMap<String, String> parsedData;

    private boolean responseShallHaveBody;

    private boolean implemented;


    static final String[] EMPTY_ARRAY = new String[0];

    static final String EMPTY_STRING = "";



    public RequestObject() {

        fullUrl = EMPTY_STRING;
        baseUrl = EMPTY_STRING;
        protocolVersion = EMPTY_STRING;
        host = EMPTY_STRING;
        accept = EMPTY_ARRAY;
        acceptLanguage = EMPTY_ARRAY;
        acceptCharset = EMPTY_ARRAY;
        acceptEncoding = EMPTY_ARRAY;
        connection = EMPTY_STRING;
        valid = true;
        parsedData = new HashMap<>();
        responseShallHaveBody = true;
        implemented = true;

    }


    @Override
    public String getFullUrl() {
        return this.fullUrl;
    }

    @Override
    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    @Override
    public boolean fullUrlIsSet() {
        return this.fullUrl.length() > 0;
    }


    @Override
    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Override
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public boolean baseUrlIsSet() {
        return this.baseUrl.length() > 0;
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
    public boolean protocolVersionIsSet() {
        return this.protocolVersion.length() > 0;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public boolean hostIsSet() {
        return this.host.length() > 0;
    }

    @Override
    public String[] getAccept() {
        return this.accept;
    }

    @Override
    public void setAccept(String[] accept) {
        this.accept = accept;
    }

    @Override
    public boolean acceptIsSet() {
        return this.accept.length > 0;
    }

    @Override
    public String[] getAcceptLanguage() {
        return this.acceptLanguage;
    }

    @Override
    public void setAcceptLanguage(String[] acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    @Override
    public boolean acceptLanguageIsSet() {
        return this.acceptLanguage.length > 0;
    }

    @Override
    public String[] getAcceptCharset() {
        return this.acceptCharset;
    }

    @Override
    public void setAcceptCharset(String[] acceptCharset) {
        this.acceptCharset = acceptCharset;
    }

    @Override
    public boolean acceptCharsetIsSet() {
        return this.acceptCharset.length > 0;
    }

    @Override
    public String[] getAcceptEncoding() {
        return this.acceptEncoding;
    }

    @Override
    public void setAcceptEncoding(String[] acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    @Override
    public boolean acceptEncodingIsSet() {
        return this.acceptEncoding.length > 0;
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
    public String getContentType() {
        return EMPTY_STRING;
    }

    @Override
    public void setContentType(String contentType) {

    }

    @Override
    public boolean contentTypeIsSet() {
        return false;
    }

    @Override
    public int getContentLength() {
        return 0;
    }

    @Override
    public void setContentLength(int contentLength) {

    }

    @Override
    public boolean contentLengthIsSet() {
        return false;
    }

    @Override
    public String getBody() {
        return EMPTY_STRING;
    }

    @Override
    public void setBody(String body) {

    }

    @Override
    public boolean bodyIsSet() {
        return false;
    }

    @Override
    public boolean isValid() {
        return this.valid;
    }

    @Override
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public HashMap<String, String> getParsedData() {
        return this.parsedData;
    }

    @Override
    public void setParsedData() {

        String url = this.getFullUrl();

        String[] data = url.split("\\?", 2);

        this.setBaseUrl(data[0]);


        if (data.length == 2) {

            String[] data2 = data[1].split("[=&]+");


            for (int i = 0; i < data2.length; i += 2) {

                this.parsedData.put(data2[i], data2[i + 1]);

            }

        }

    }

    @Override
    public boolean parsedDataIsSet() {
        return !this.parsedData.isEmpty();
    }



    public boolean responseShallHaveBody() {
        return  this.responseShallHaveBody;
    }

    public void setResponseShallHaveBody(boolean responseShallHaveBody) {
        this.responseShallHaveBody = responseShallHaveBody;
    }


    public boolean isImplemented() {
        return this.implemented;
    }

    public void setImplemented(boolean implemented) {
        this.implemented = implemented;
    }


}
