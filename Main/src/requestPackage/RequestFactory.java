package requestPackage;

import requestPackage.MethodEnum.Method;
import static java.util.Arrays.copyOfRange;

/**
 * @author Daniel Björnberger
 */
public class RequestFactory {

    public RequestObject createRequestObject(String input) {


        RequestObject requestObject = new RequestObject();


        input = "POST /cgi-bin/process.cgi HTTP/1.1\n" +
                "User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\n" +
                "Host: www.tutorialspoint.com\n" +
                "Content-Type: application/x-www-form-urlencoded\n" +
                "Content-Length: length\n" +
                "Accept-Language: en-us,swed, english,spanish\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Connection: Keep-Alive\n\nBody-Body-Body..........";

        System.out.println(input + "\n\n");


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
                    requestObject.setUrl(currentRow[1]);
                    break;

                case "HEAD":
                    requestObject.setMethod(Method.HEAD);
                    requestObject.setUrl(currentRow[1]);
                    break;

                case "POST":
                    requestObject.setMethod(Method.POST);
                    requestObject.setUrl(currentRow[1]);
                    break;

                case "Host:":
                    requestObject.setHost(currentRow[1]);
                    break;

                case "Accept:":
                    requestObject.setAccept(copyOfRange(currentRow, 1, currentRow.length));
                    break;

                case "Accept-Language:":
                    requestObject.setAcceptLanguage(copyOfRange(currentRow, 1, currentRow.length));
                    break;

                case "Accept-Charset:":
                    requestObject.setAcceptCharset(copyOfRange(currentRow, 1, currentRow.length));
                    break;

                case "Accept-Encoding:":
                    requestObject.setAcceptEncoding(copyOfRange(currentRow, 1, currentRow.length));
                    break;

                case "Connection:":
                    requestObject.setConnection(currentRow[1]);
                    break;

                default:
                    break;

            }

        }

        return requestObject;

    }

}
