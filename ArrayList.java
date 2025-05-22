import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayList {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();  // Number of lines
        List<List<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = scan.nextInt();  // Number of elements in the line
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                line.add(scan.nextInt());
            }
            lines.add(line);
        }

        int q = scan.nextInt();  // Number of queries

        for (int i = 0; i < q; i++) {
            int x = scan.nextInt();  // Line number (1-based)
            int y = scan.nextInt();  // Position number (1-based)

            if (x <= lines.size() && y <= lines.get(x - 1).size() && y > 0) {
                System.out.println(lines.get(x - 1).get(y - 1));
            } else {
                System.out.println("ERROR!");
            }
        }

        scan.close();
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}