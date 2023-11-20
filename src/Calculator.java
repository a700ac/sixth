 class Calculator {


    public static int calc(String a, int operand1, int operand2) {
    int res=0;
         if (a.contains("+")) res = operand1 + operand2;
         if (a.contains("-")) res = operand1 - operand2;
         if (a.contains("*")) res = operand1 * operand2;
         if (a.contains("/")) res = operand1 / operand2;

         return res;
     }
 }
