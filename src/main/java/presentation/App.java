package presentation;


import data_access.UnitOfWork;
import businessLogic.commands.*;


import java.util.Scanner;

public class App {
    private UnitOfWork context = null;

    private void getPersistence() {
        try {
            this.context = new UnitOfWork();
        } catch (Exception e) {
            System.out.println("Something went wrong with the initialization of the JPAContext.");
            System.exit(1);
        }
    }

    private void displayMenu() {
        int i = 0;
        System.out.println("Menu");
        System.out.println();
        System.out.println(i + ". Exit");
        System.out.println(++i + ". Create Player");
        System.out.println(++i + ". Deactivate Player");
        System.out.println(++i + ". Ban Player");
        System.out.println(++i + ". Get Player Total Points");
        System.out.println(++i + ". Get Player Total Games");
        System.out.println(++i + ". Get Player Points In a Certain Game");
        System.out.println(++i + ". Associate Badge");
        System.out.println(++i + ". Start New Conversation");
        System.out.println(++i + ". Add Player To A Conversation");
        System.out.println(++i + ". Send A Message");
        System.out.println(++i + ". Players Info");
    }

    public void runApp() throws Exception {
        displayMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a command number: ");
        String command = scanner.nextLine();
        new commands().getCommands().get(command).execute();

    }

    public static void main(String[] args) throws Exception {
        new App().runApp();
    }
}
