package requestpackage;

/**
 * @author Daniel Björnberger
 */
public class NotImplementedRequest extends RequestObject {

    NotImplementedRequest() {

        super();
        this.setImplemented(false);

    }



    @Override
    public void setParsedData() {

    }



    /** The method 'toString' is only for testing purpose.
     * @return The method returns a String representation of a RequestObject.
     */
    @Override
    public String toString() {

        return  "Method: NOT_IMPLEMENTED";

    }


}
