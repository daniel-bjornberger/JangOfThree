package responsepackage;

/**
 * @author Daniel Björnberger
 */
public class ResponseStringGenerator {


    public String createResponseString(ResponseObject responseObject) throws Exception {

        if (responseObject.statusIsSet() && responseObject.statusMessageIsSet() && responseObject.contentTypeIsSet() && responseObject.serverIsSet()) {


            StringBuilder builder = new StringBuilder(responseObject.getProtocolVersion() + " " +
                    responseObject.getStatus() + " " + responseObject.getStatusMessage());


            responseObject.setDate();

            builder.append("\nDate: " + responseObject.getDate());

            builder.append("\nServer: " + responseObject.getServer());

            builder.append("\nContent-Type: " + responseObject.getContentType());



            builder.append("\nContent-Length: " + responseObject.getContentLength());


            if (responseObject.contentLanguageIsSet()) {

                builder.append("\nContent-Language: " + responseObject.getContentLanguage());

            }

            if (responseObject.connectionIsSet()) {

                builder.append("Connection: " + responseObject.getConnection());

            }

            if (responseObject.bodyIsSet()) {

                builder.append("\n\n" + responseObject.getBody());

            }

            return builder.toString();

        }

        else throw new Exception("Insufficient information, a response can not be created.");

    }


}
