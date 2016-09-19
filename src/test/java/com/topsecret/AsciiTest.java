package com.topsecret;

import org.junit.Test;
import com.topsecret.Ascii;

import static org.junit.Assert.*;

/*
 *
 */
public class AsciiTest {
    @Test public void testAscii() {
        Ascii clazz = new Ascii();
        clazz.generateAscii("<Text test>", 100, true);
        clazz.generateAscii("walken.jpg", 160, false);
        clazz.generateAscii("maxresportrait.jpg", 300, true);
         
    }
}
