import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class List {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(); // initial number of elements
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }

        int q = scan.nextInt(); // number of queries

        for (int i = 0; i < q; i++) {
            String command = scan.next();

            if (command.equals("Insert")) {
                int index = scan.nextInt();
                int value = scan.nextInt();
                list.add(index, value);
            } else if (command.equals("Delete")) {
                int index = scan.nextInt();
                list.remove(index);
            }
        }

        scan.close();

        // Print the modified list
        for (int num : list) {
            System.out.print(num + " ");
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}