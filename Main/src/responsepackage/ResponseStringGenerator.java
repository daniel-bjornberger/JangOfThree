package responsepackage;

/**
 * @author Daniel Björnberger
 */
public class ResponseStringGenerator {


    public String createResponseString(ResponseObject responseObject) throws Exception {


        if (responseObject.statusIsSet() && responseObject.statusMessageIsSet()
                && responseObject.contentTypeIsSet() && responseObject.contentLengthIsSet()) {

            StringBuilder builder = new StringBuilder(responseObject.getProtocolVersion() + " " +
                    responseObject.getStatus() + " " + responseObject.getStatusMessage());

            responseObject.setDate();

            builder.append("\nDate: ").append(responseObject.getDate());

            builder.append("\nServer: ").append(responseObject.getServer());

            builder.append("\nContent-Type: ").append(responseObject.getContentType());

            builder.append("\nContent-length: ").append(responseObject.getContentLength());


            if (responseObject.contentLanguageIsSet()) {

                builder.append("\nContent-Language: ").append(responseObject.getContentLanguage());

            }

            if (responseObject.connectionIsSet()) {

                builder.append("\nConnection: ").append(responseObject.getConnection());

            }


            return builder.toString();

        }

        else throw new Exception("Insufficient information, a response can not be created.");

    }


}
