package businessLogic.View;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ConsoleView implements View {

    private static final String APP_TITLE = "On Track Management";

    public void clear() {
        for (int y = 0; y < 25; y++) //console is 80 columns and 25 lines
            System.out.println("\n");
    }

    private final void println(String s) {
        System.out.println(s);
    }

    private static void println() {
        System.out.println();
    }

    private final void print(String s) {
        System.out.print(s);
    }

    /*private final void printList(List list) {
        for (Object o : list)
            print(o.toString() + "\n");
    }*/

    @Override
    public final Integer getInputInt() throws RuntimeException {
        //try to get input as int , but if a '\n' is found, return null
        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input == null || input.isEmpty())
                return null;

            return Integer.parseInt(input);
        } catch (NoSuchElementException e) { //input equals '\n'
            println("Invalid input.");
            return null;
        } catch (NumberFormatException e) { //input is not an int
            println("Input must be a number.");
            throw new RuntimeException("Invalid input.");
        }
    }

    @Override
    public final Double getInputDouble() throws RuntimeException {
        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input == null || input.isEmpty())
                return null;

            return Double.parseDouble(input);
        } catch (NoSuchElementException e) { //input equals '\n'
            println("Invalid input.");
            return null;
        } catch (NumberFormatException e) { //input is not a number
            println("Input must be a number.");
            throw new RuntimeException("Invalid input.");
        }
    }

    @Override
    public final BigDecimal getInputBigDecimal() throws RuntimeException {
        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input == null || input.isEmpty())
                return null;

            return BigDecimal.valueOf(Double.parseDouble(input));
        } catch (NoSuchElementException e) { //input equals '\n'
            println("Invalid input.");
            return null;
        } catch (NumberFormatException e) { //input is not a number
            println("Input must be a number.");
            throw new RuntimeException("Invalid input.");
        }
    }

    @Override
    public String getInputString() {
        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input == null || input.isEmpty())
                return null;

            return input;
        } catch (NoSuchElementException e) { //input equals '\n'
            println("Invalid input.");
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Invalid input");
        }
    }

    @Override
    public Integer getInputInt(String message) throws RuntimeException {
        print(message);
        return getInputInt();
    }

    @Override
    public final String getInputString(String message) {
        print(message);
        return getInputString();
    }

    @Override
    public final Double getInputDouble(String message) throws RuntimeException {
        print(message);
        return getInputDouble();
    }

    @Override
    public final BigDecimal getInputBigDecimal(String message) throws RuntimeException {
        print(message);
        return getInputBigDecimal();
    }

    @Override
    public void showMessage(String message) {
        println(message);
    }

    public final void displayError(String s) {
        println(s);
    }

    public final void waitForInput() throws IOException {
        //TODO não é suposto retornar o que é lido?
        System.in.read();
    }

    @Override
    public void printList(List<?> list) {
        //TODO melhorar isto
        println(list.toString());
    }
}