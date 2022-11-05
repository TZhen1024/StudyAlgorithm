package Daily;

public class Leetcode1106 {
    public static void main(String[] args) {
        Leetcode1106 leetcode1106 = new Leetcode1106();
        String expression = "|(&(t,f,t),t)";
        System.out.println(leetcode1106.parseBoolExpr(expression));
    }

    int i = 0;
    public boolean parseBoolExpr(String expression) {
        if (expression.charAt(i) == 't') {
            i++;
            return true;
        } else if (expression.charAt(i) == 'f') {
            i++;
            return false;
        } else if (expression.charAt(i) == '&') {
            i += 2; // 跳过'('到expr的起点
            boolean temp = true;
            while (expression.charAt(i) != ')') {
                temp = parseBoolExpr(expression) && temp;
                if (expression.charAt(i) == ',') {
                    i++;
                }
            }
            i++;
            return temp;
        } else if (expression.charAt(i) == '|') {
            i += 2;
            boolean temp = false;
            while (expression.charAt(i) != ')') {
                temp = parseBoolExpr(expression) || temp;
                if (expression.charAt(i) == ',') {
                    i++;
                }
            }
            i++;
            return temp;
        } else if (expression.charAt(i) == '!') {
            i += 2;
            boolean temp = parseBoolExpr(expression);
            temp = !temp;
            i++;
            return temp;
        } else {
            System.out.println("Not a valid character. " + expression.charAt(i));
        }
        return false;
    }

}
