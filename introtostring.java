import java.io.*;
import java.util.*;

public class introtostring {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        
        // 2. Print "Yes" if A is lexicographically greater than B, else "No"
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        
        // 3. Capitalize the first letter of A and B
        String capA = A.substring(0, 1).toUpperCase() + A.substring(1);
        String capB = B.substring(0, 1).toUpperCase() + B.substring(1);
        System.out.println(capA + " " + capB);
        
    }
}



