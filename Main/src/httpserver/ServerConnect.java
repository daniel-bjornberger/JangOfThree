package httpserver;

import requestpackage.*;
import responsepackage.Response;
import responsepackage.ResponseObject;
import responsepackage.ResponseStringGenerator;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

// The tutorial can be found just here on the SSaurel's Blog : 
// https://www.ssaurel.com/blog/create-a-simple-http-web-server-in-java
// Each Client Connection will be managed in a dedicated Thread
public class ServerConnect extends Observable implements Runnable{

    static final File WEB_ROOT = new File(".");
    static final String DEFAULT_FILE = "index.html";
    static final String FILE_NOT_FOUND = "404.html";
    static final String METHOD_NOT_SUPPORTED = "not_supported.html";
    // port to listen connection
    static int PORT = 8082;
    private ServerSocket serverSocket;
    private String requestString;



    // verbose mode
    static final boolean verbose = true;

    // Client Connection via Socket Class
    private Socket connect;



    public ServerConnect(Observer observer,ServerSocket serverSocket){

        addObserver(observer);
        try {

            this.serverSocket=serverSocket;
            this.connect= serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRequestString() {
        return requestString;
    }

   /* public static void main(String[] args) {
        try {

            //serverSocket = new ServerSocket(PORT);
            //System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");

            // we listen until user halts server execution
            while (true) {
                ServerConnect myServer = new ServerConnect(serverSocket.accept());

                if (verbose) {
                    System.out.println("Connecton opened. (" + new Date() + ")");
                }

                // create dedicated thread to manage the client connection
                Thread thread = new Thread(myServer);
                thread.start();
            }

        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }*/

    @Override
    public void run() {
        // we manage our particular client connection
        BufferedReader in = null; PrintWriter out = null; BufferedOutputStream dataOut = null;
        String fileRequested = null;

        try {
            // we read characters from the client via input stream on the socket
            in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            // we get character output stream to client (for headers)
            out = new PrintWriter(connect.getOutputStream());
            // get binary output stream to client (for requested data)
            dataOut = new BufferedOutputStream(connect.getOutputStream());
            // get first line of the request from the client
            in.mark(9999999);
            StringBuilder stringBuilder = new StringBuilder();

            String thisLine= in.readLine();

            do {
                stringBuilder.append(thisLine).append("\n");
                thisLine = in.readLine();

            } while (!thisLine.isEmpty());

            requestString = stringBuilder.toString();

            RequestFactory requestFactory = new RequestFactory();

            Request request = requestFactory.createRequestObject(requestString);

            System.out.println("\n=======================\nRequest object created!\n=======================");



            if (request.contentLengthIsSet()) {

                int contentLength = request.getContentLength();

                StringBuilder body = new StringBuilder();

                int c;

                for (int i = 0; i < contentLength; i++) {

                    c = in.read();
                    body.append((char) c);

                }

                request.setBody(body.toString());
            }
            System.out.println("REWUEST BODYYYYYY  :"+request.getBody());

            RequestHandler requestHandler = new RequestHandler();

            Response response = requestHandler.doEverything(request);




            ResponseStringGenerator rsg = new ResponseStringGenerator();
            String responseString= rsg.createResponseString((ResponseObject) response);
            System.out.println("=======================================");
            System.out.println("Response string is:" + responseString);
            System.out.println("=======================================");


           // setChanged();
            //notifyObservers(requestString);
           // System.out.println(requestString);
            in.reset();
            String input = in.readLine();


            // we parse the request with a string tokenizer
            StringTokenizer parse = new StringTokenizer(requestString);
            String method = parse.nextToken().toUpperCase(); // we get the HTTP method of the client
            // we get file requested
            fileRequested = parse.nextToken().toLowerCase();
            System.out.println("filerequested BLALA:" + fileRequested);
            System.out.println("Response.getBody:" + response.getBody());
            // we support only GET and HEAD methods, we check

                // GET or HEAD method
               fileRequested =response.getBody();
               // if (fileRequested.endsWith("/")) {
               //     fileRequested += DEFAULT_FILE;
               // }

                File file = new File(WEB_ROOT, fileRequested);

                int fileLength;
               // String content = getContentType(fileRequested);
                boolean isFile= false;
                //OM STATISK FIL:

                if(        response.isStaticFile()
                        //staticFileHandler.isStaticContentType(response)
                 ) {
                    isFile = true;
                    System.out.println("file is true");
                } else {
                    System.out.println("file is false");
                }


                //boolean isFile = Arrays.stream(staticFileHandler.getFormats()).filter(p -> p.equals(response.getContentType())).findFirst().isPresent();
                byte[] fileData;
                if (isFile){
                    file = new File(WEB_ROOT,response.getBody());
                    fileLength = (int) file.length();
                    fileData = readFileData(file, fileLength);
                    System.out.println("file length is ACTUALLY " + fileLength);
                }
                else{
                    fileData = response.getBody().getBytes();
                    fileLength =  response.getBody().getBytes().length;

                }




               // if (method.equals("GET")) {

                    // GET method so we return content
                    //fileData = readFileData(file, fileLength);

                    // send HTTP Headers
                 //   out.println("HTTP/1.1 200 OK");
                 //  out.println("Server: Java HTTP Server from SSaurel : 1.0");
                 //   out.println("Date: " + new Date());
                 //   out.println("Content-type: " + /*content*/"image/jpeg");
                 //   out.println("Content-length: " + fileLength);
                 //   System.out.println("Sending response string...");
                   out.println(responseString);
                out.println(); // blank line between headers and content, very important !
                out.flush(); // flush character output stream buffer
                    System.out.println("Response String Sent:");
                System.out.println("---------------------------------");
                System.out.println(responseString);
                System.out.println("---------------------------------");


                if (response.responseHasBody()) {
                    dataOut.write(fileData, 0, fileLength);
                    dataOut.flush();
                }
                //System.out.println(Arrays.toString(fileData));
               // }

                if (verbose) {
                  //  System.out.println("File " + fileRequested + " of type " + content + " returned");
                }



        } catch (FileNotFoundException fnfe) {
            try {
                fileNotFound(out, dataOut, fileRequested);
            } catch (IOException ioe) {
                System.err.println("Error with file not found exception : " + ioe.getMessage());
            }

        } catch (IOException ioe) {
            System.err.println("Server error : " + ioe);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                dataOut.close();
                connect.close(); // we close socket connection
            } catch (Exception e) {
                System.err.println("Error closing stream : " + e.getMessage());
            }

            if (verbose) {
                System.out.println("Connection closed.\n");
            }
        }


    }

    private byte[] readFileData(File file, int fileLength) throws IOException {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[fileLength];

        try {
            fileIn = new FileInputStream(file);
            fileIn.read(fileData);
        } finally {
            if (fileIn != null)
                fileIn.close();
        }

        return fileData;
    }

    // return supported MIME Types
    private String getContentType(String fileRequested) {
        if (fileRequested.endsWith(".htm")  ||  fileRequested.endsWith(".html"))
            return "text/html";
        else
            return "text/plain";
    }

    private void fileNotFound(PrintWriter out, OutputStream dataOut, String fileRequested) throws IOException {
        File file = new File(WEB_ROOT, FILE_NOT_FOUND);
        int fileLength = (int) file.length();
        String content = "text/html";
        byte[] fileData = readFileData(file, fileLength);

        out.println("HTTP/1.1 404 File Not Found");
        out.println("Server: Java HTTP Server from SSaurel : 1.0");
        out.println("Date: " + new Date());
        out.println("Content-type: " + content);
        out.println("Content-length: " + fileLength);
        out.println(); // blank line between headers and content, very important !
        out.flush(); // flush character output stream buffer

        dataOut.write(fileData, 0, fileLength);
        dataOut.flush();

        if (verbose) {
            System.out.println("File " + fileRequested + " not found");
        }
    }

}