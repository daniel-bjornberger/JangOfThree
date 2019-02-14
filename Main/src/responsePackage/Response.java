package responsePackage;

/**
 * @author Daniel Björnberger
 */
public interface Response {


    String getVersion();

    void setVersion(String version);


    String getStatus();

    void setStatus(String status);


    String getStatusMessage();

    void setStatusMessage(String statusMessage);


    String getDate();

    void setDate(String date);


    String getServer();

    void setServer(String server);


    String[] getContentType();

    void setContentType(String[] contentType);


    int getContentLength();

    void setContentLength(int contentLength);


    String[] getContentLanguage();

    void setContentLanguage(String[] contentLanguage);


    String getConnection();

    void setConnection(String connection);


    String getBody();

    void setBody(String body);


}
