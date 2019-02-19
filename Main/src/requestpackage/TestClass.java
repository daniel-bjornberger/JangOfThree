package requestpackage;


import static java.util.Arrays.copyOfRange;


public class TestClass {

    public static void main (String[] args) {




        /*String input = "POST /cgi-bin/process.cgi HTTP/1.1\n" +
                "User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\n" +
                "Host: www.tutorialspoint.com\n" +
                "Content-Type: application/x-www-form-urlencoded\n" +
                "Content-Length: length\n" +
                "Accept-Language: en-us,sWEd, engLish,Spanish\n" +
                "Accept-Encoding: gzip,     deFLate\n" +
                "Connection: Keep-Alive\n\nBody-Body-Body..........";*/


        String input = "GET /foo.php?first_name=John&last_name=Doe&action=Submit HTTP/1.1\n" +
                "Host: localhost\n" +
                "User-Agent: Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.5) Gecko/20091102 Firefox/3.5.5 (.NET CLR 3.5.30729)\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
                "Accept-Language: en-us,en;q=0.5\n" +
                "Accept-Encoding: gzip,deflate\n" +
                "Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7\n" +
                "Keep-Alive: 300\n" +
                "Connection: keep-alive\n" +
                "Referer: http://localhost/test.php\n";



        input = "POST /foo.php HTTP/1.1\n" +
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
                "Content-Length: 43\n\n" +
                "first_name=John&last_name=Doe&action=Submit";






        System.out.println(input + "\n\n");


        String[] inputRowByRow = input.split("\\n");

        String[] currentRow = inputRowByRow[0].split("[,\\s]+");

        RequestObject requestObject;


        switch (currentRow[0]) {

            case "GET":
                requestObject = new GetRequest();
                requestObject.setFullUrl(currentRow[1].toLowerCase());
                requestObject.setProtocolVersion(currentRow[2].toLowerCase());
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

                    //System.out.println("Content-length i requestfactory = " + requestObject.getContentLength() + "\n\n");

                    if (requestObject.getContentLength() > 0) {
                        requestObject.setBody(inputRowByRow[inputRowByRow.length - 1]);
                    }
                    break;

                default:
                    break;

            }

        }

        requestObject.setParsedData();

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
