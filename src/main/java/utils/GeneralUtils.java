package utils;

import org.jsoup.Jsoup;

/**
 * Created by sourabh.su on 25/01/17.
 */
public class GeneralUtils {
    public static String html2text(String html) {
        if (html !=null)
            return Jsoup.parse(html).text();
        return null;
    }

    public static String getDescriptionFromContent(String html) {
        String description = html2text(html);
        if (description!= null)
            description = description.substring(0,Math.min(200,description.length()-1));
        return description;
    }
}
