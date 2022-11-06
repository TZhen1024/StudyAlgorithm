package Daily;

public class Leetcode1678 {
    public static void main(String[] args) {

    }

    public String interpret(String command) {
        return command.replace("(al)", "al").replace("()", "o");
    }
}
