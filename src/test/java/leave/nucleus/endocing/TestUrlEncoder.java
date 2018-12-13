package leave.nucleus.endocing;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TestUrlEncoder {

    @Test
    public void testDecoding() {
        try {
            System.out.print(URLDecoder.decode("%3Cp%3EA%20quick%20brown%20fox%3C%2Fp%3E", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}