package requestPackage;

import requestPackage.MethodEnum.Method;

/**
 * @author Daniel Björnberger
 */
public interface Request {

    Method getMethod();

    void setMethod(Method method);


    String getUrl();

    void setUrl(String url);


    String getProtocolVersion();

    void setProtocolVersion(String protocolVersion);


    String getHost();

    void setHost(String host);


    String[] getAccept();

    void setAccept(String[] accept);


    String[] getAcceptLanguage();

    void setAcceptLanguage(String[] acceptLanguage);


    String[] getAcceptCharset();

    void setAcceptCharset(String[] acceptCharset);


    String[] getAcceptEncoding();

    void setAcceptEncoding(String[] acceptEncoding);


    String getConnection();

    void setConnection(String connection);


    String getBody();

    void setBody(String body);


    boolean isValid();

    void setValid(boolean valid);


}
