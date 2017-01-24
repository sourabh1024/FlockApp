package utils;

import org.jsoup.Jsoup;

/**
 * Created by sourabh.su on 25/01/17.
 */
public class GeneralUtils {
    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }

    public static String getDescriptionFromContent(String html) {
        String description = html2text(html);
        description = description.substring(0,Math.min(200,description.length()));
        return description;
    }
}
