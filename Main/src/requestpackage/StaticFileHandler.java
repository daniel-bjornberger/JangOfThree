package requestpackage;

import responsepackage.Response;

public class StaticFileHandler {
    public static String[] getFormats() {
        return formats;
    }

    private static String[] formats= {
            ".html",
            ".css",
            ".js",
            ".pdf",
            ".png",
            ".jpg",
            ".jpeg",
            ".ico"
    };
    private static String[] contentTypes={
            "text/html",
            "text/css",
            "text/javascript",
            "application/pdf",
            "image/png",
            "image/jpeg",
            "image/x-icon"
    };

    public static boolean isStaticContentType(Response response){
        for (String contentType:contentTypes){
            if (response.getContentType().equals(contentType)){
                return true;
            }
        }
        return false;
    }

    public static String detect(Request request){
        for(String format: formats) {
            if (request.getFullUrl().endsWith(format)) {
                return format;
            }
        }
        return null;
    }





}
