package loadServices;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ServiceLoader;


/** @author Pontus Fredriksson */
public class ServiceHandler {
    ServiceLoader<Service> services;


    /** Constructor
     * @param fileLocation The local path to directory of service modules*/
    public ServiceHandler(String fileLocation){
        loadServices(fileLocation);
    }

    public void loadServices(String fileLocation) {
        File location = new File(fileLocation);

        File[] fileList = location.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getPath().toLowerCase().endsWith(".jar");
            }
        });
        URL[] urls = new URL[fileList.length];
        for (int i = 0; i <fileList.length; i++){
            try {
                urls[i] = fileList[i].toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        services = ServiceLoader.load(Service.class,new URLClassLoader(urls));
    }

    public void checkAdress(String adress){

        for (Service service: services){
            if(service.getClass().getAnnotation(Adress.class).value().equals(adress))
            {

            }

        }
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        for(Service service:services){
            output.append(service.toString());
        }
        return output.toString();
    }
}
