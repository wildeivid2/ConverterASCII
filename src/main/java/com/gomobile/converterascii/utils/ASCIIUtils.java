/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gomobile.converterascii.utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author wdc
 */
public class ASCIIUtils {
    
    
    public static String converterTextToASCII(final String text) {
        final var asciiBytes = text.getBytes(StandardCharsets.US_ASCII);
        final var stringAscii = Arrays.toString(asciiBytes);
        final var array = stringAscii.split(",");
        final var list = Arrays.asList(array);
        
        return list.stream()
                .map(item -> item.trim())
                .collect(Collectors.joining("."))
                .replaceAll("\\[", "")
                .replaceAll("\\]", "");
    }
    
    public static String converterASCIIToText(final String ascii) {
        return Arrays.asList(ascii.split("[.]"))
                .stream()
                .map(Integer::decode)
                .map(item -> Character.toString(item))
                .peek(item -> System.out.print(item))
                .collect(Collectors.joining());
                
    }
    
}
