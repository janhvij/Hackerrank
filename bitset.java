import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class bitset {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
int n = sc.nextInt(); // Size of BitSets
int m = sc.nextInt(); // Number of operations

BitSet b1 = new BitSet(n);
BitSet b2 = new BitSet(n);

for (int i = 0; i < m; i++) {
    String op = sc.next();
    int x = sc.nextInt(); // Operand BitSet number (1 or 2)
    int y = sc.nextInt(); // Operand index or second BitSet

    BitSet target = (x == 1) ? b1 : b2;
    BitSet other = (x == 1) ? b2 : b1;

    switch (op) {
        case "AND":
            target.and(other);
            break;
        case "OR":
            target.or(other);
            break;
        case "XOR":
            target.xor(other);
            break;
        case "FLIP":
            target.flip(y);
            break;
        case "SET":
            target.set(y);
            break;
    }

    System.out.println(b1.cardinality() + " " + b2.cardinality());
}

    }
}