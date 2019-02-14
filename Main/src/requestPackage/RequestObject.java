package requestPackage;

import requestPackage.MethodEnum.Method;
import java.util.Arrays;

/**
 * @author Daniel Björnberger
 */
public class RequestObject implements Request {


    private Method method;

    private String url;

    private String protocolVersion;

    private String host;

    private String[] accept;

    private String[] acceptLanguage;

    private String[] acceptCharset;

    private String[] acceptEncoding;

    private String connection;

    private String body;


    private static final String[] EMPTY_ARRAY = new String[0];

    private static final String EMPTY_STRING = "";



    public RequestObject() {
        method = Method.OTHER;
        url = EMPTY_STRING;
        protocolVersion = EMPTY_STRING;
        host = EMPTY_STRING;
        accept = EMPTY_ARRAY;
        acceptLanguage = EMPTY_ARRAY;
        acceptCharset = EMPTY_ARRAY;
        acceptEncoding = EMPTY_ARRAY;
        connection = EMPTY_STRING;
        body = EMPTY_STRING;

    }


    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public void setMethod(Method method) {
        this.method = method;
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
    public String getUrl() {
        return this.url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
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
    public String[] getAccept() {
        return this.accept;
    }

    @Override
    public void setAccept(String[] accept) {
        this.accept = accept;
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
    public String[] getAcceptCharset() {
        return this.acceptCharset;
    }

    @Override
    public void setAcceptCharset(String[] acceptCharset) {
        this.acceptCharset = acceptCharset;
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

        return  "Method: " +
                this.method +
                "\nUrl: " +
                this.url +
                "\nProtocol Version: " +
                this.protocolVersion +
                "\nHost: " +
                this.host +
                "\nAccept: " +
                Arrays.toString(this.accept) +
                "\nAccept-Language: " +
                Arrays.toString(this.acceptLanguage) +
                "\nAccept-Charset: " +
                Arrays.toString(this.acceptCharset) +
                "\nAccept-Encoding: " +
                Arrays.toString(this.acceptEncoding) +
                "\nConnection: " +
                this.connection +
                "\nBody: " +
                this.body;

    }

}
