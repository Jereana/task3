package com.epam.rd.java.basic.practice3;
import java.security.*;

public class Part4 {

    public static void main(String[] args) {
       
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
       
    }
    
    public static String hash(String input, String algorithm) {
        StringBuilder sb = new StringBuilder();
        
        try{
            MessageDigest md;
            md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            byte[] hashInBytes = md.digest();
        
            for (int i = 0; i < hashInBytes.length; i++) {
                sb.append(Integer.toString((hashInBytes[i]& 0xFF) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e){
            System.out.println(e.getMessage()); 
          }
        return sb.toString().toUpperCase();
    }
}
