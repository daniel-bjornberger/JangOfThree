package requestpackage;

public class staticFileHandler {
    private static String[] formats= {
            ".html",
            ".css",
            ".js",
            ".pdf",
            ".png"

    };

    public static String detect(Request request){
        for(String format: formats) {
            if (request.getUrl().endsWith(format)) {
                return format;
            }
        }
        return null;
    }





}
