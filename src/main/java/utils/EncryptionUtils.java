package utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class EncryptionUtils {

    public static String getCryptoHash(String input) {

        return DigestUtils.md5Hex(input);
    }
}
