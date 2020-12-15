package project;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Util {

    public static String encode(String encodedText) {
        final Base64.Encoder encoder = Base64.getEncoder();
        byte[] textByte = encodedText.getBytes(StandardCharsets.UTF_8);
        String encodeToString = encoder.encodeToString(textByte);
        System.out.println("encodedText = " + encodedText + ", encodeToString = " + encodeToString);
        return encodeToString;
    }

    public static String decode(String decodedText) {
        Base64.Decoder decoder = Base64.getDecoder();
        String decodeString = new String(decoder.decode(decodedText), StandardCharsets.UTF_8);
        System.out.println("decodedText = " + decodedText + ", decodeString = " + decodeString);
        return decodeString;
    }


}
