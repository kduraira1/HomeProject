import java.util.Stack;
public class ParanthesisCheck {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if (s.length() == 1 || (s.length() % 2 != 0)) {
            System.out.println("Validation check failed");
            return false;
        }
        for(char ch : chars) {
            switch(ch) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default :
                    if (stack.isEmpty() || ch != stack.pop() ) return false;
                    break;
            }

        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
            ParanthesisCheck pc = new ParanthesisCheck();
            System.out.println(pc.isValid("[{(}]"));
    }

}
