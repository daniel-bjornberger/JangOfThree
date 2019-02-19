package requestpackage;

public class staticFileHandler {
    public static String[] getFormats() {
        return formats;
    }

    private static String[] formats= {
            ".html",
            ".css",
            ".js",
            ".pdf",
            ".png",
            ".jpg"

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
