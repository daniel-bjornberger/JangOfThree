package requestPackage;

import requestPackage.MethodEnum.Method;
import static java.util.Arrays.copyOfRange;


public class TestClass {

    public static void main (String[] args) {

        RequestObject requestObject = new RequestObject();


        /*String input = "POST /cgi-bin/process.cgi HTTP/1.1\n" +
                "User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\n" +
                "Host: www.tutorialspoint.com\n" +
                "Content-Type: application/x-www-form-urlencoded\n" +
                "Content-Length: length\n" +
                "Accept-Language: en-us,sWEd, engLish,Spanish\n" +
                "Accept-Encoding: gzip,     deFLate\n" +
                "Connection: Keep-Alive\n\nBody-Body-Body..........";*/


        String input = "POST /foo.php HTTP/1.1\n" +
                "Host: localhost\n" +
                "User-Agent: Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.5) Gecko/20091102 Firefox/3.5.5 (.NET CLR 3.5.30729)\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
                "Accept-Language: en-us,en;q=0.5\n" +
                "Accept-Encoding: gzip,deflate\n" +
                "Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7\n" +
                "Keep-Alive: 300\n" +
                "Connection: keep-alive\n" +
                "Referer: http://localhost/test.php\n" +
                "Content-Type: application/x-www-form-urlencoded\n" +
                "Content-Length: 43\n" +
                "\n" +
                "first_name=John&last_name=Doe&action=Submit";

        System.out.println(input + "\n\n");


        String[] inputRowByRow = input.split("\\n");

        //System.out.println(inputRowByRow.length);


        if (inputRowByRow[inputRowByRow.length - 2].length() == 0) {

            //System.out.println("Hej!");

            requestObject.setBody(inputRowByRow[inputRowByRow.length - 1]);

            //inputRowByRow = copyOfRange(inputRowByRow, 0, inputRowByRow.length - 2);

        }

        //System.out.println(inputRowByRow.length);


        String[] currentRow;


        for (String s : inputRowByRow) {

            currentRow = s.split("[,\\s]+");

            System.out.println(currentRow[0]);


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

                case "Content-Type:":
                    requestObject.setContentType(currentRow[1].toLowerCase());
                    break;

                case "Content-Length:":
                    requestObject.setContentLength(Integer.valueOf(currentRow[1]));
                    System.out.println(currentRow[1]);
                    break;

                default:
                    break;

            }

        }

        System.out.println(requestObject.toString());




    }



    private static String[] stringArrayToLowerCase(String[] stringArray) {

        String[] newStringArray = new String[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {

            newStringArray[i] = stringArray[i].toLowerCase();

        }

        return newStringArray;

    }


}
