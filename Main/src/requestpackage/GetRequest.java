package requestpackage;

import java.util.Arrays;

/**
 * @author Daniel Björnberger
 */
public class GetRequest extends RequestObject {

    GetRequest() {

        super();

    }



    /** The method 'toString' is only for testing purpose.
     * @return The method returns a String representation of a RequestObject.
     */
    @Override
    public String toString() {

        StringBuilder returnString = new StringBuilder("Method: GET" +
                "\nFull Url: " +
                this.getFullUrl() +
                "\nBase Url: "+
                this.getBaseUrl() +
                "\nProtocol Version: " +
                this.getProtocolVersion() +
                "\nHost: " +
                this.getHost() +
                "\nAccept: " +
                Arrays.toString(this.getAccept()) +
                "\nAccept-Language: " +
                Arrays.toString(this.getAcceptLanguage()) +
                "\nAccept-Charset: " +
                Arrays.toString(this.getAcceptCharset()) +
                "\nAccept-Encoding: " +
                Arrays.toString(this.getAcceptEncoding()) +
                "\nConnection: " +
                this.getConnection() +
                "\nValid: " +
                this.isValid() + "\n");

        for (String name: this.getParsedData().keySet()){

            returnString.append(name).append(": ").append(this.getParsedData().get(name)).append("\n");

        }

        return returnString.toString();

    }


}
