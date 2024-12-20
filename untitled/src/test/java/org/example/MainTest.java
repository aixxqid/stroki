package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MainTest {

    @Test
    public void stroka1() {
        String slovo = "b";
        String N = "3";
        String expected = "bbb";
        String actual = Main.dop(slovo, N);
        assertEquals(expected, actual);
    }


    @Test
    public void vtoroe() {
        String one = "b";
        String two = "";
        assertThrows(IllegalArgumentException.class, () -> Main.kolvo(one,two));
    }


    @Test
    public void three() {
        String vxod = "1";
        String expected = "один";
        assertEquals(expected, Main.replaceNumbers(vxod));
    }


    @Test
    public void four() {
        String stroka = "пумба";
        String res = "пма";
        assertEquals(res, Main.delete(stroka));
    }

}