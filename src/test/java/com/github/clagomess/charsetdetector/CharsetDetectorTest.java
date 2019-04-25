package com.github.clagomess.charsetdetector;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class CharsetDetectorTest {
    @Test
    public void utf8() throws IOException {
        URL utf8 = Thread.currentThread().getContextClassLoader().getResource("utf-8.txt");
        FileInputStream fis = new FileInputStream(utf8.getFile());

        Assert.assertEquals(Charset.forName("UTF-8"), CharsetDetectorUtil.detect(fis));
    }

    @Test
    public void ansi() throws IOException {
        URL iso_8859_1 = Thread.currentThread().getContextClassLoader().getResource("iso-8859-1.txt");
        FileInputStream fis = new FileInputStream(iso_8859_1.getFile());

        Assert.assertEquals(Charset.forName("ISO-8859-1"), CharsetDetectorUtil.detect(fis));
    }

    @Test
    public void byteArray(){
        byte[] ba = "Ação Açucar".getBytes();
        Assert.assertEquals(Charset.forName("UTF-8"), CharsetDetectorUtil.detect(ba));
    }

    @Test
    public void text(){
        Assert.assertEquals(Charset.forName("UTF-8"), CharsetDetectorUtil.detect("Ação Açucar"));
    }

    @Test
    public void nullSafe() throws IOException {
        byte[] a = null;
        String b = null;
        FileInputStream c = null;

        Assert.assertNull(CharsetDetectorUtil.detect(a));
        Assert.assertNull(CharsetDetectorUtil.detect(b));
        Assert.assertNull(CharsetDetectorUtil.detect(c));
    }
}
