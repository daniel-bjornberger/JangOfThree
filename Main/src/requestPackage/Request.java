package requestPackage;

/**
 * @author Daniel Björnberger
 */
public interface Request {

    String getMethod();

    void setMethod(String method);


    String getUrl();

    void setUrl(String url);


    String getHost();

    void setHost(String host);


    String getAccept();

    void setAccept(String accept);


    String getAcceptLanguage();

    void setAcceptLanguage(String acceptLanguage);


    String getAcceptCharset();

    void setAcceptCharset(String acceptCharset);


    String getBody();

    void setBody(String body);

}
