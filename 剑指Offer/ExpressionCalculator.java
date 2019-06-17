import java.util.HashMap;
import java.util.Stack;

// 表达式求值
public class ExpressionCalculator{
    public boolean isOperator(String op){
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    public String[] convertToRPN(String[] expression){
        Stack<String> operatorStack=new Stack<>();
        HashMap<String,Integer> order=new HashMap<>();
        order.put("+",0);
        order.put("-",0);
        order.put("*",1);
        order.put("/",1);
        String result="";
        for(int i=0;i<expression.length;i++){
            if(!isOperator(expression[i])){
                result+=expression[i]+"_";
            }
            else{
                // 如果当前操作符比栈顶操作符优先级小，出栈添加到后缀表达式
                while(!operatorStack.empty() && order.get(expression[i])<=order.get(operatorStack.peek())){
                    result+=operatorStack.pop()+"_";
                }
                operatorStack.push(expression[i]);
            }
        }
        while(!operatorStack.empty()){
            result+=operatorStack.pop();
        }
        String[] splited=result.split("_");
        return splited;
    }

    public String calculateRPN(String[] RPN){
        String answer="";
        Stack<String> operandStack=new Stack<>();
        for(int i=0;i<RPN.length;i++){
            if(!isOperator(RPN[i])){
                operandStack.push(RPN[i]);
            }
            else{
                int partAns=-1;
                int op1=Integer.parseInt(operandStack.pop().trim());
                int op2=Integer.parseInt(operandStack.pop().trim());
                if(RPN[i].equals("+")){
                    partAns=op1+op2;
                }
                else if(RPN[i].equals("-")){
                    partAns=op2-op1;
                }
                else if(RPN[i].equals("*")){
                    partAns=op1*op2;
                }
                else if(RPN[i].equals("/")){
                    partAns=op2/op1;
                }
                operandStack.push(String.valueOf(partAns));
            }
        }
        answer=operandStack.pop();
        return answer;
    }

    // 便于处理
    public String[] getSplited(String expression){
        String[] result=null;
        expression=expression.replaceAll("\\+",",+,");
        expression=expression.replaceAll("-",",-,");
        expression=expression.replaceAll("\\*",",*,");
        expression=expression.replaceAll("/",",/,");
        expression=expression.replaceAll("\\(",",(,");
        expression=expression.replaceAll("\\)",",),");

        result=expression.split(",");
        return result;
    }
    public static void main(String[] args){
        ExpressionCalculator calculator=new ExpressionCalculator();
        String[] expression=null;
//        Scanner scanner=new Scanner(System.in);
//        expression=calculator.getSplited(scanner.next());
        expression=calculator.getSplited("1+21*3-6");
        String[] RPN=calculator.convertToRPN(expression);
        String answer=calculator.calculateRPN(RPN);
        System.out.println(answer);

    }
}