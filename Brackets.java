import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * Brackets
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 */
public class Brackets {


    /**
     * Given a string S consisting of N characters, 
     * returns 1 if S is properly nested and 0 otherwise.
     * 
     * Execution: O(n) - Space: O(1)
     */
    static public int brackets(String s) {

        // **** sanity checks ****
        if (s == null) return 0;
        if (s.length() == 0) return 1;

        // **** initialization ****
        Stack<Character> stack = new Stack<>();

        // **** traverse string looking for unmatched brackets ****
        for (char ch : s.toCharArray()) {

            // **** proceed based on current character - O(n) ****
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {

                // **** check if stack is empty ****
                if (stack.size() == 0) return 0;

                // **** validate character ****
                if (ch == ')') {
                    if (stack.pop() != '(') return 0;
                } else if (ch == ']') {
                    if (stack.pop() != '[') return 0;
                } else if (ch == '}') {
                    if (stack.pop() != '{') return 0;
                } else
                    return 0;
            }
        }

        // **** check stack contents ****
        if (stack.size() != 0) return 0;

        // **** string is valid ****
        return 1;
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read string ****
        String s = br.readLine().trim();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< s ==>" + s + "<==");

        // **** call function of interest and display result ****
        System.out.println("main <<< result: " + brackets(s));
    }
}