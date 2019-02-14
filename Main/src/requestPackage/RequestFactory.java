package requestPackage;

import requestPackage.MethodEnum.Method;
import static java.util.Arrays.copyOfRange;

/**
 * @author Daniel Björnberger
 */
public class RequestFactory {


    public RequestObject createRequestObject(String input) {


        RequestObject requestObject = new RequestObject();

        String[] inputRowByRow = input.split("\\n");


        if (inputRowByRow[inputRowByRow.length - 2].length() == 0) {

            requestObject.setBody(inputRowByRow[inputRowByRow.length - 1]);

        }


        String[] currentRow;


        for (String s : inputRowByRow) {

            currentRow = s.split("[,\\s]+");


            switch (currentRow[0]) {

                case "GET":
                    requestObject.setMethod(Method.GET);
                    requestObject.setUrl(currentRow[1].toLowerCase());
                    requestObject.setProtocolVersion(currentRow[2].toLowerCase());
                    break;

                case "HEAD":
                    requestObject.setMethod(Method.HEAD);
                    requestObject.setUrl(currentRow[1].toLowerCase());
                    requestObject.setProtocolVersion(currentRow[2].toLowerCase());
                    break;

                case "POST":
                    requestObject.setMethod(Method.POST);
                    requestObject.setUrl(currentRow[1].toLowerCase());
                    requestObject.setProtocolVersion(currentRow[2].toLowerCase());
                    break;

                case "Host:":
                    requestObject.setHost(currentRow[1].toLowerCase());
                    break;

                case "Accept:":
                    requestObject.setAccept(stringArrayToLowerCase(copyOfRange(currentRow, 1, currentRow.length)));
                    break;

                case "Accept-Language:":
                    requestObject.setAcceptLanguage(stringArrayToLowerCase(copyOfRange(currentRow, 1, currentRow.length)));
                    break;

                case "Accept-Charset:":
                    requestObject.setAcceptCharset(stringArrayToLowerCase(copyOfRange(currentRow, 1, currentRow.length)));
                    break;

                case "Accept-Encoding:":
                    requestObject.setAcceptEncoding(stringArrayToLowerCase(copyOfRange(currentRow, 1, currentRow.length)));
                    break;

                case "Connection:":
                    requestObject.setConnection(currentRow[1].toLowerCase());
                    break;

                default:
                    break;

            }

        }

        return requestObject;

    }


    private String[] stringArrayToLowerCase(String[] stringArray) {

        String[] newStringArray = new String[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {

            newStringArray[i] = stringArray[i].toLowerCase();

        }

        return newStringArray;

    }


}
