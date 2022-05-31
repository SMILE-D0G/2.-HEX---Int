package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        String Hex1 = "ff00000000000000000000000000000000000000000000000000000000000000";
        BigInteger BigEnd = new BigInteger(HexToBigEnd(Hex1));
        System.out.println("Hex: " + Hex1);
        System.out.println("->");
        System.out.println("Big Endian: " + BigEnd);
        System.out.println();
        String Hex2 = "aaaa000000000000000000000000000000000000000000000000000000000000";
        BigInteger LitEnd = new BigInteger(HexToLitEnd(Hex2));
        System.out.println("Hex: " + Hex2);
        System.out.println("->");
        System.out.println("Little Endian: " + LitEnd);
        System.out.println();
        String BigEnd1 = "4294967295";
        String Hex01 = BigEndToHex(BigEnd1);
        System.out.println("Big Endian: " + BigEnd1);
        System.out.println("->");
        System.out.println("Hex: " + Hex01);
        System.out.println();
        String LitEnd1 = "240";
        int Bytes2 = 512;
        String Hex02 = LitEndToHex(LitEnd1, Bytes2 * 2);
        System.out.println("Little Endian: " + LitEnd1);
        System.out.println("->");
        System.out.println("Hex: " + Hex02);
        System.out.println();

    }

    public static String HexToBigEnd(String Hex) {
        BigInteger BigInt = new BigInteger(Hex, 16);
        String BigEnd = BigInt.toString();
        return BigEnd;
    }

    public static String HexToLitEnd(String Hex) {
        StringBuilder sb = new StringBuilder(Hex);
        sb.reverse();
        Hex = sb.toString();
        BigInteger BigInt = new BigInteger(Hex, 16);
        String LitEnd = BigInt.toString();
        return LitEnd;
    }

    public static String BigEndToHex(String BigEnd) {
        BigInteger BigInt = new BigInteger(BigEnd);
        String Hex = BigInt.toString(16);
        return Hex;
    }

    public static String LitEndToHex(String LitEnd, int Length) {
        BigInteger BigInt = new BigInteger(LitEnd);
        String Hex = BigInt.toString(16);
        int HexLen = Hex.length();
        StringBuilder sb = new StringBuilder(Hex);
        sb.reverse();
        for (int i = 0; i < Length - HexLen; i++)
            sb.insert(0, 0);
        Hex = sb.toString();
        return Hex;
    }
}
