import java.util.*;
class Stack{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            Stack<Character> stack = new Stack<>();
    boolean balanced = true;
    for (char ch : input.toCharArray()) {
        if ("({[".indexOf(ch) != -1) {
            stack.push(ch);
        } else {
            if (stack.isEmpty()) {
                balanced = false;
                break;
            }
            char top = stack.pop();
            if ((ch == ')' && top != '(') ||
                (ch == '}' && top != '{') ||
                (ch == ']' && top != '[')) {
                balanced = false;
                break;
            }
        }
    }
    System.out.println(balanced && stack.isEmpty());
		}
		
	}
}



