package genericPackage;

import jdk.internal.instrumentation.TypeMapping;
import loadServices.Adress;
import loadServices.Service;
import loadServices.Type;
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

    }
}
