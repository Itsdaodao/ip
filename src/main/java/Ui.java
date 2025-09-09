public class Ui {
    private static final String newLine = """
            
            GEORGE the monkey LOVES to eat bananas!\
            
            """;

    private static final String greeting = """
            Ooo eee ooo aaa aaa\s
            I am George the Monkey\
            
            George can help you with?""";

    private static final String exitMessage = "I love bananas \nplease bring bananas next time";

    public void showWelcome() {
        System.out.println(greeting);
        System.out.println(newLine);
    }

    public void showExit() {
        System.out.println("\n" + exitMessage);
    }

    public void showError(String errorMessage) {
        System.out.println("OOPS!!! " + errorMessage);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public String readInput() {
        return "";
    }
}
