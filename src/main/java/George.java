import java.util.Scanner;

public class George {
    public static void main(String[] args) {
        String BANANA = "\uD83C\uDF4C";
        String MONKEY = "🐒";

        String newLine = "\n" + MONKEY + BANANA.repeat(20) + MONKEY + "\n";
        Scanner scanner = new Scanner(System.in);
        String greeting = "Ooo eee ooo aaa aaa I am George the Monkey"
                + MONKEY
                + "\nGeorge help you with?";
        System.out.println(greeting);
        System.out.println(newLine);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                String exit = "I love bananas " + BANANA.repeat(5)
                        + "\nplease bring bananas next time";
                System.out.println("\n" + exit);
                break;
            }

            System.out.println(newLine + input + newLine);
        }
    }
}
