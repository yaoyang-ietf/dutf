package com.yaoyang.dutf;

import sun.nio.cs.Surrogate;

import java.util.Arrays;

/**
 * @author yao.yang
 * @version 1.0
 * @className DUTF2
 * @description
 * @date 2023/3/25
 */
public class DUTF2 {

    private static Surrogate.Parser parser = new Surrogate.Parser();

    /**
     * Encode a string as an array of bytes
     *
     * @param value raw string
     * @return byte array
     */
    public static byte[] encode(String value) {
        byte[] buffer = new byte[value.length() * 3];
        int lastCodePoint = 0;
        int lastOffset = 0;
        int pos = 0;
        int i = 0;
        char[] chars = value.toCharArray();
        int length = chars.length;
        for (char c; i < length && ((c = chars[i]) & ~0x7F) == 0; i++) {
            buffer[pos++] = (byte) c;
        }
        for (char c; i < length; i++) {
            c = chars[i];
            if ((c & ~0x7F) == 0) {
                buffer[pos++] = (byte) c;
            } else {
                int codePoint = c;
                if (Character.isSurrogate(c)) {
                    codePoint = parser.parse(c, chars, i, value.length());
                    i++;
                }
                int offset = codePoint ^ lastCodePoint;
                if ((offset & ~0x1F) == 0) {
                    buffer[pos++] = (byte) (offset & 0x1F | 0x80);
                } else if ((offset & ~0x1FFF) == 0) {
                    buffer[pos++] = (byte) (offset & 0x1F | 0xA0);
                    buffer[pos++] = (byte) (offset >>> 5);
                } else {
                    int encodedOffset = offset ^ lastOffset;
                    if ((encodedOffset & ~0x1FFF) == 0) {
                        buffer[pos++] = (byte) (encodedOffset & 0x1F | 0xC0);
                        buffer[pos++] = (byte) (encodedOffset >>> 5);
                    } else {
                        buffer[pos++] = (byte) (offset & 0x1F | 0xE0);
                        buffer[pos++] = (byte) (offset >>> 5);
                        buffer[pos++] = (byte) (offset >>> 13);
                    }
                    lastOffset = offset;
                }
                lastCodePoint = codePoint;
            }
        }
        return Arrays.copyOf(buffer, pos);
    }

    /**
     * Decode the byte array as a string
     *
     * @param bytes encoded byte array
     * @return decoded string
     */
    public static String decode(byte[] bytes) {
        int length = bytes.length;
        char[] chars = new char[length];
        int pos = 0;
        int lastCodePoint = 0;
        int lastOffset = 0;
        int i = 0;
        for (byte b; i < length && ((b = bytes[i]) & ~0x7F) == 0; i++) {
            chars[pos++] = (char) b;
        }
        for (byte b; i < length; i++) {
            b = bytes[i];
            if ((b & ~0x7F) == 0) {
                chars[pos++] = (char) b;
            } else {
                int offset;
                int flag = ((b & 0xE0) >>> 5);
                if (flag == 0B100) {
                    offset = b & 0x1F;
                } else if (flag == 0B101) {
                    offset = (b & 0x1F) | ((bytes[++i] & 0xFF) << 5);
                } else if (flag == 0B110) {
                    offset = ((b & 0x1F) | ((bytes[++i] & 0xFF) << 5)) ^ lastOffset;
                    lastOffset = offset;
                } else if (flag == 0B111) {
                    offset = (b & 0x1F) | ((bytes[++i] & 0xFF) << 5) | ((bytes[++i] & 0xFF) << 13);
                    lastOffset = offset;
                } else {
                    throw new IllegalArgumentException("invalid DUTF octet");
                }
                int codePoint = offset ^ lastCodePoint;
                if (!Character.isValidCodePoint(codePoint)) {
                    throw new IllegalArgumentException("invalid character codePoint");
                }
                if (Character.isBmpCodePoint(codePoint)) {
                    chars[pos++] = (char) codePoint;
                } else {
                    chars[pos++] = Character.highSurrogate(codePoint);
                    chars[pos++] = Character.lowSurrogate(codePoint);
                }
                lastCodePoint = codePoint;
            }
        }
        return new String(chars, 0, pos);
    }

}
