package requestpackage;

import java.util.Arrays;

/**
 * @author Daniel Björnberger
 */
public class HeadRequest extends RequestObject {


    public HeadRequest() {

        super();

    }







    /** The method 'toString' is only for testing purpose.
     * @return The method returns a String representation of a RequestObject.
     */
    @Override
    public String toString() {

        return  "Method: HEAD" +
                "\nUrl: " +
                this.getFullUrl() +
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
                this.isValid();

    }

}
