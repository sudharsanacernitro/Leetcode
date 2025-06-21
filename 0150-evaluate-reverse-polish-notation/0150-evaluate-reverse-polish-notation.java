class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack=new Stack<>();

        int n=tokens.length;

        int result=0;

        for(int i=0;i<n;i++)
        {
            boolean isOperator=checkOperator(tokens[i]);

            if(isOperator)
            {
                int op2=stack.pop();
                int op1=stack.pop();

                switch(tokens[i])
                {
                    case "+":
                        result=(op1+op2);
                        break;
                    case "-":
                        result=(op1-op2);
                        break;
                    case "*":
                        result=(op1*op2);
                        break;
                    case "/":
                        result=(op1/op2);
                        break;
                }
                stack.push(result);
            }
            else stack.push(Integer.parseInt(tokens[i]));
            

        }

        return stack.pop();

    }

   boolean checkOperator(String token) {
    return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
}

}