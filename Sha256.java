import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sha256 {

    public static void main(String[] args) {try {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    // Get SHA-256 MessageDigest instance
    java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
    md.update(input.getBytes());
    byte[] digest = md.digest();

    // Convert the byte array to hex string
    StringBuilder sb = new StringBuilder();
    for (byte b : digest) {
        sb.append(String.format("%02x", b & 0xff));
    }

    System.out.println(sb.toString());
} catch (Exception e) {
    e.printStackTrace();
}

    }
}