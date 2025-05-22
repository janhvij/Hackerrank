import java.util.*;

public class queue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, map.size());
                int removed = deque.removeFirst();

                int count = map.get(removed);
                if (count == 1) {
                    map.remove(removed);
                } else {
                    map.put(removed, count - 1);
                }
            }
        }

        System.out.println(maxUnique);
    }
}
