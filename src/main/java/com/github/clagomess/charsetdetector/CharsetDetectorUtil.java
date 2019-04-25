package com.github.clagomess.charsetdetector;

import org.apache.tika.parser.txt.CharsetDetector;
import org.apache.tika.parser.txt.CharsetMatch;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class CharsetDetectorUtil {
    public static Charset detect(InputStream is) throws IOException {
        if(is == null){
            return null;
        }

        CharsetDetector charsetDetector = new CharsetDetector();
        charsetDetector.setText( is instanceof BufferedInputStream ? is : new BufferedInputStream(is) );
        charsetDetector.enableInputFilter(true);
        CharsetMatch cm = charsetDetector.detect();
        return Charset.forName(cm.getName());
    }

    public static Charset detect(byte[] text){
        if(text == null){
            return null;
        }

        CharsetDetector charsetDetector = new CharsetDetector();
        charsetDetector.setText(text);
        charsetDetector.enableInputFilter(true);
        CharsetMatch cm = charsetDetector.detect();
        return Charset.forName(cm.getName());
    }

    public static Charset detect(String text){
        if(text == null){
            return null;
        }

        return detect(text.getBytes());
    }
}
