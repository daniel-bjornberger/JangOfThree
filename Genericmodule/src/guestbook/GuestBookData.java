package guestbook;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import loadservices.Adress;
import loadservices.Service;
import loadservices.ServiceHandler;
import loadservices.Type;
import requestpackage.Request;
import responsepackage.Response;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Adress("/guestbookgetdata")
@Type("utility")
public class GuestBookData implements Service {


    /**
     * @author Joel Gunnarsson
     */



        @Override
        public void execute(Request request, Response response) {
            ServiceHandler serviceHandler = new ServiceHandler("out/artifacts/lib/");
            System.out.println("Running GuestBookData module...2");
            response.setStatus("200");
            response.setStatusMessage("OK");
            response.setContentType("text/plain");

            StringBuilder stringBuilder = new StringBuilder();
            GuestBookDB guestBookDB=new GuestBookDB();
            ArrayList <Visitors> visitorsArrayList= new ArrayList<Visitors>(guestBookDB.findAllVisitors());
            for(Visitors s:visitorsArrayList) {


                    stringBuilder.append(
                            "<p><b>Name:"+s.getFirstName()+"</b></p>\n" +
                                    "<p><b>Comment:"+s.getMesseges()+"</b></p>\n" +
                                    "<hr>"
                    );
            }
            response.setBody(
                  //<p><b>Name:</b></p>
                    //<p><b>Comment:</b></p>
                    //<hr>
                    stringBuilder.toString()
            );
            System.out.println(response.getBody());
            response.setContentLength(response.getBody().length());
            response.setStaticFile(false);
        }

        @Override
        public String toString() {
            return "GenericModuleClass";
        }
    }


