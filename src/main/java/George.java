import java.util.Scanner;

public class George {
    public static void main(String[] args) {
        String BANANA = "\uD83C\uDF4C";
        String MONKEY = "🐒";

        String newLine = MONKEY + BANANA.repeat(20) + MONKEY;
        Scanner scanner = new Scanner(System.in);


        String greeting = "Ooo eee ooo aaa aaa I am George the Monkey"
                + MONKEY
                + "\nGeorge help you with?";
        System.out.println(greeting);
        System.out.println(newLine);

        String exit = "I love bananas " + BANANA.repeat(5) + "\nplease bring banana next time";
        System.out.println("\n" + exit);
    }
}
