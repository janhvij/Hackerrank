import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Bitinteger {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Read two big integers
        BigInteger a = new BigInteger(scan.nextLine());
        BigInteger b = new BigInteger(scan.nextLine());

        // Print their sum
        System.out.println(a.add(b));

        // Print their product
        System.out.println(a.multiply(b));
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}