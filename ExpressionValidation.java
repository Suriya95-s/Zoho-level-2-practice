import java.util.Scanner;
import java.util.Stack;

public class ExpressionValidation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String exp = scan.nextLine();
        String result = validCheck(exp);
        System.out.println(result);
    }

    static String validCheck(String exp)
    {
        Stack<Character> bracket = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int i=0;
        while(i<exp.length())
        {
            if(exp.charAt(i) == '(')
            {
                bracket.push('(');
                i++;
            }
            else if (exp.charAt(i) == 'a' || exp.charAt(i) == 'b' || exp.charAt(i) == '+' || exp.charAt(i) == '*' || exp.charAt(i) == '-' || exp.charAt(i) == '/') {
                if(exp.charAt(i) == 'a' && exp.charAt(i+1) == 'b')
                {
                    return "Invalid";
                }
                if(exp.charAt(i) =='a' && exp.charAt(i+1) == '+' || exp.charAt(i+1) == '*' || exp.charAt(i+1) == '-' || exp.charAt(i+1) == '/' )
                {
                    operator.push('a');
                    operator.push(exp.charAt(i+1));
                    i=i+2;
                }
                else if(exp.charAt(i) =='b' && operator.peek() == '+' || operator.peek()== '*' || operator.peek() == '-' || operator.peek() == '/' )
                {
                    while (!operator.isEmpty())
                    {
                        operator.pop();
                    }
                    i++;
                }
                else {
                    return "Invalid";
                }

            }

            else {
                if(exp.charAt(i) == ')')
                {
                    if(!bracket.isEmpty() && bracket.peek() == '(')
                    {
                        bracket.pop();
                        if(!bracket.isEmpty())
                        {
                            return "Invalid";
                        }
                        i++;
                    }
                    else {
                        return "Invalid";
                    }
                }
            }
        }
        return "Valid";
    }
}
