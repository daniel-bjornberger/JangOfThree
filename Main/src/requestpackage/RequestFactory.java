package requestpackage;

import static java.util.Arrays.copyOfRange;

/**
 * @author Daniel Björnberger
 */
public class RequestFactory {


    public RequestObject createRequestObject(String input) {


        String[] inputRowByRow = input.split("\\n");

        String[] currentRow = inputRowByRow[0].split("[,\\s]+");

        RequestObject requestObject;


        switch (currentRow[0]) {

            case "GET":
                requestObject = new GetRequest();
                requestObject.setFullUrl(currentRow[1].toLowerCase());
                requestObject.setProtocolVersion(currentRow[2].toLowerCase());
                requestObject.setResponseShallHaveBody(true);
                break;

            case "HEAD":
                requestObject = new HeadRequest();
                requestObject.setFullUrl(currentRow[1].toLowerCase());
                requestObject.setProtocolVersion(currentRow[2].toLowerCase());
                break;

            case "POST":
                requestObject = new PostRequest();
                requestObject.setFullUrl(currentRow[1].toLowerCase());
                requestObject.setProtocolVersion(currentRow[2].toLowerCase());
                requestObject.setResponseShallHaveBody(true);
                break;

            default:
                requestObject = new NotImplementedRequest();
                break;

        }


        for (int i = 1; i < inputRowByRow.length; i++) {

            currentRow = inputRowByRow[i].split("[,\\s]+");


            switch (currentRow[0]) {

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

                    if (requestObject.getContentLength() > 0) {
                        requestObject.setBody(inputRowByRow[inputRowByRow.length - 1]);
                        System.out.println("Case Content-length: " + inputRowByRow[inputRowByRow.length - 1]);
                    }
                    break;

                default:
                    break;

            }

        }

        requestObject.setParsedData();

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
