package com.yaoyang.dutf;

import sun.nio.cs.Surrogate;

import java.util.Arrays;

/**
 * @author yao.yang
 * @version 1.0
 * @className DUTF
 * @description
 * @date 2023/3/25
 */
public class DUTF {

    private static Surrogate.Parser parser = new Surrogate.Parser();

    public static byte[] encode(String value) {
        byte[] buffer = new byte[value.length() * 3];
        int last = 0;
        int pos = 0;
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((c & ~0x7F) == 0) {
                buffer[pos++] = (byte) c;
            } else {
                int codePoint = c;
                if (Character.isSurrogate(c)) {
                    codePoint = parser.parse(c, chars, i, value.length());
                    i++;
                }
                int offset = codePoint ^ last;
                if ((offset & ~0x3FFF) == 0) {
                    buffer[pos++] = (byte) (offset & 0x7F | 0x80);
                    buffer[pos++] = (byte) (offset >>> 7);
                } else {
                    buffer[pos++] = (byte) (offset & 0x7F | 0x80);
                    buffer[pos++] = (byte) ((offset >>> 7) & 0x7F | 0x80);
                    buffer[pos++] = (byte) (offset >>> 14);
                }
                last = codePoint;
            }
        }
        return Arrays.copyOf(buffer, pos);
    }

    public static String decode(byte[] bytes) {
        char[] chars = new char[bytes.length];
        int pos = 0;
        int last = 0;
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & ~0x7F) == 0) {
                chars[pos++] = (char) bytes[i];
            } else {
                int codePoint = 0;
                int disp = 0;
                while (true) {
                    byte b = bytes[i];
                    codePoint |= ((b & 0x7F) << disp);
                    if ((b & ~0x7F) == 0) {
                        codePoint = codePoint ^ last;
                        break;
                    }
                    disp += 7;
                    i++;
                }
                if (!Character.isValidCodePoint(codePoint)) {
                    throw new IllegalArgumentException("Character codePoint is valid");
                }
                if (Character.isBmpCodePoint(codePoint)) {
                    chars[pos++] = (char) codePoint;
                } else {
                    chars[pos++] = Character.highSurrogate(codePoint);
                    chars[pos++] = Character.lowSurrogate(codePoint);
                }
                last = codePoint;
            }
        }
        return new String(chars, 0, pos);
    }


}
