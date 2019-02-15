package genericpackage;

import loadservices.Adress;
import loadservices.Service;
import loadservices.Type;
import requestPackage.Request;
import responsePackage.Response;

/**
 * @author Pontus Fredriksson
 */
@Adress("/genericmoduleclass")
@Type ("URL")
public class GenericModuleClass implements Service {


    @Override
    public void execute(Request request, Response response) {
        //if request.getUrl().
    }

    @Override
    public String toString() {
        return "GenericModuleClass";
    }
}
