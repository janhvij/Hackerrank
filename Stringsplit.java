import java.io.*;
import java.util.*;

public class Stringsplit {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        scan.close();
          String[] tokens = s.trim().split("[^a-zA-Z]+");

        // Filter empty strings (in case of leading/trailing separators)
        List<String> words = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                words.add(token);
            }
        }

        // Print number of words
        System.out.println(words.size());

        // Print each word in a new line
        for (String word : words) {
            System.out.println(word);
        }
    }
}

