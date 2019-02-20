package requestpackage;

import java.util.HashMap;

/**
 * @author Daniel Björnberger
 */
public interface Request {

    String getFullUrl();

    void setFullUrl(String fullUrl);

    boolean fullUrlIsSet();


    String getBaseUrl();

    void setBaseUrl(String baseUrl);

    boolean baseUrlIsSet();


    String getProtocolVersion();

    void setProtocolVersion(String protocolVersion);

    boolean protocolVersionIsSet();


    String getHost();

    void setHost(String host);

    boolean hostIsSet();


    String[] getAccept();

    void setAccept(String[] accept);

    boolean acceptIsSet();


    String[] getAcceptLanguage();

    void setAcceptLanguage(String[] acceptLanguage);

    boolean acceptLanguageIsSet();


    String[] getAcceptCharset();

    void setAcceptCharset(String[] acceptCharset);

    boolean acceptCharsetIsSet();


    String[] getAcceptEncoding();

    void setAcceptEncoding(String[] acceptEncoding);

    boolean acceptEncodingIsSet();


    String getConnection();

    void setConnection(String connection);

    boolean connectionIsSet();


    String getContentType();

    void setContentType(String contentType);

    boolean contentTypeIsSet();


    int getContentLength();

    void setContentLength(int contentLength);

    boolean contentLengthIsSet();


    String getBody();

    void setBody(String body);

    boolean bodyIsSet();


    boolean isValid();

    void setValid(boolean valid);


    HashMap<String, String> getParsedData();

    void setParsedData();

    boolean parsedDataIsSet();


    boolean responseShallHaveBody();

    void setResponseShallHaveBody(boolean responseShallHaveBody);


}
