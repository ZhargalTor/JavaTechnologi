package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarTest {

    private final Caesar caesar = new Caesar();

    @Test
    void encryptLowerCase() {
        assertEquals("нсх", caesar.encrypt("кот", 3));
    }

    @Test
    void decryptLowerCase() {
        assertEquals("кот", caesar.decrypt("нсх", 3));
    }

    @Test
    void encryptUpperCase() {
        assertEquals("НСХ", caesar.encrypt("КОТ", 3));
    }

    @Test
    void decryptUpperCase() {
        assertEquals("КОТ", caesar.decrypt("НСХ", 3));
    }

    @Test
    void mixedCase() {
        assertEquals("Нсх", caesar.encrypt("Кот", 3));
    }

    @Test
    void withSpaces() {
        assertEquals("нсх усё", caesar.encrypt("кот рог", 3));
    }

    @Test
    void alphabetWrap() {
        assertEquals("ж", caesar.encrypt("д", 3));
    }

    @Test
    void negativeKey() {
        assertEquals("злп", caesar.encrypt("кот", -3));
    }

    @Test
    void bigKey() {
        assertEquals(caesar.encrypt("кот", 7), caesar.encrypt("кот", 40));
    }

    @Test
    void emptyString() {
        assertEquals("", caesar.encrypt("", 3));
    }

    @Test
    void numbersRemainSame() {
        assertEquals("123", caesar.encrypt("123", 3));
    }

    @Test
    void punctuationRemainSame() {
        assertEquals("!,.", caesar.encrypt("!,.", 3));
    }
}