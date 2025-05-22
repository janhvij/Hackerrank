import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        a = a.toLowerCase();
    b = b.toLowerCase();

    // If lengths differ, they can't be anagrams
    if (a.length() != b.length()) {
        return false;
    }

    // Frequency arrays for 'a' to 'z'
    int[] freqA = new int[26];
    int[] freqB = new int[26];

    for (int i = 0; i < a.length(); i++) {
        freqA[a.charAt(i) - 'a']++;
        freqB[b.charAt(i) - 'a']++;
    }

    // Compare frequency counts
    for (int i = 0; i < 26; i++) {
        if (freqA[i] != freqB[i]) {
            return false;
        }
    }

    return true;
        
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}