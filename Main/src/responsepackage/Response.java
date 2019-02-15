package responsepackage;

/**
 * @author Daniel Björnberger
 */
public interface Response {


    String getProtocolVersion();

    void setProtocolVersion(String protocolVersion);


    String getStatus();

    void setStatus(String status);

    boolean statusIsSet();


    String getStatusMessage();

    void setStatusMessage(String statusMessage);

    boolean statusMessageIsSet();


    String getDate();

    void setDate();

    boolean dateIsSet();


    String getServer();

    void setServer(String server);

    boolean serverIsSet();


    String getContentType();

    void setContentType(String contentType);

    boolean contentTypeIsSet();


    int getContentLength();

    void setContentLength(int contentLength);

    boolean contentLengthIsSet();


    String getContentLanguage();

    void setContentLanguage(String contentLanguage);

    boolean contentLanguageIsSet();


    String getConnection();

    void setConnection(String connection);

    boolean connectionIsSet();


    String getBody();

    void setBody(String body);

    boolean bodyIsSet();


}
