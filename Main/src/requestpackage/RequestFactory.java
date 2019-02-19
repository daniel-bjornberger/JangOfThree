package requestpackage;

import requestpackage.MethodEnum.Method;
import static java.util.Arrays.copyOfRange;

/**
 * @author Daniel Björnberger
 */
public class RequestFactory {


    public RequestObject createRequestObject(String input) {


        String[] inputRowByRow = input.split("\\n");

        String[] currentRow = inputRowByRow[0].split("[,\\s]+");


        switch (currentRow[0]) {



        }



        RequestObject requestObject = new RequestObject();










        if (inputRowByRow[inputRowByRow.length - 2].length() == 0) {

            requestObject.setBody(inputRowByRow[inputRowByRow.length - 1]);

        }





        for (int i = 1; i < inputRowByRow.length; i++) {

            currentRow = inputRowByRow[i].split("[,\\s]+");


            switch (currentRow[0]) {

                /*case "GET":
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
                    break;*/

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

                case "Content-Type:":
                    requestObject.setContentType(currentRow[1].toLowerCase());
                    break;

                case "Content-Length:":
                    requestObject.setContentLength(Integer.valueOf(currentRow[1]));
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
