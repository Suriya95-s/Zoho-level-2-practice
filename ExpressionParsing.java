
import java.util.Map;
import java.util.Stack;

public class ExpressionParsing {
    public static void main(String[] args) {
        try{
            String exp1 = " ((1 AND 2) OR 3) ";
            String exp2 = " (1 AND ((2 OR 3) OR 4)) ";
            String exp3 = "(1 ((2 OR 3) OR 4)"; //non proper expression
            Map<String,Boolean> condVal = Map.of(
                    "1",false,
                    "2",true,
                    "3",true,
                    "4",false
            );
            System.out.println(evaluateExp(exp1,condVal));
            System.out.println(evaluateExp(exp2,condVal));
            System.out.println(evaluateExp(exp3,condVal));

        }
        catch (IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static boolean evaluateExp(String exp,Map<String,Boolean> condVal) throws IllegalArgumentException
    {
        try{
            for(Map.Entry<String,Boolean> mapEntry : condVal.entrySet())
            {
                exp = exp.replace(mapEntry.getKey(),mapEntry.getValue().toString());
            }

            exp.replaceAll("\\s+","");

            Stack<Boolean> valueStk = new Stack<>();
            Stack<String> OperatorStk = new Stack<>();

            for(int i=0;i<exp.length();i++)
            {
                char ch = exp.charAt(i);
                //process paranthesis
                if(ch == '(')
                {
                    OperatorStk.push("(");
                }
                else if(ch == ')')
                {
                    if(!OperatorStk.isEmpty() && !OperatorStk.peek().equals('('))
                    {
                        valueStk.push(operateVal(OperatorStk.pop(),valueStk.pop(),valueStk.pop()));
                    }
                    OperatorStk.pop();
                }

                //process boolean values
                else if(ch == 't' || ch== 'f')
                {
                    boolean val = ch == 't';
                    valueStk.push(val);
                    i += 3; //skip true or false;
                }

                //process Bitwise and / or operator
                else if(i+2<exp.length() && (exp.substring(i,i+3).equals("AND") || exp.substring(i,i+2).equals("OR")))
                {
                    if(exp.substring(i,i+3).equals("AND"))
                    {
                        OperatorStk.push("AND");
                        i += 2;//skip AND
                    }
                    else
                    {
                        OperatorStk.push("OR");
                        i += 1;//skip OR
                    }
                }

            }

            if(!OperatorStk.isEmpty())
            {
                valueStk.push(operateVal(OperatorStk.pop(),valueStk.pop(),valueStk.pop()));
            }

            //return final

            return valueStk.pop();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }

    //performing operation
    private static boolean operateVal(String op,boolean a , boolean b)
    {
        switch (op)
        {
            case "AND":
                return a && b;
            case "OR":
                return a || b;
            default:
                throw new IllegalArgumentException("Unknown Operator" + op);
        }

    }
}

