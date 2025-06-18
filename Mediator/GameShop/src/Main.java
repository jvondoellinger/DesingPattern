import menu.MenuFactory;

import java.util.concurrent.ExecutionException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Depois fazer um mediator para realizar uma ação e, em caso de erro, somente expôr a mensagem!
    // Com isso, aumentará a resiliencia da aplicação!
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting application...");
        var menu = MenuFactory.getGameManagementMenu();
        menu.show().get();
        System.out.println("Stopping application...");
    }
}