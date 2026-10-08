package se.iths.felix.webshop;

import java.util.Locale;

public class ConsoleHandler implements OutInputHandler {
    @Override
    public String prompt(String message) {
        String promptMsg = IO.readln(message);
        return promptMsg;
    }

    @Override
    public void info(String message) {
        IO.println(message);
    }

    @Override
    public String menu() {
        String choice = IO.readln("""
                
                What do you want to do?
                1. Add a product
                2. List all products
                3. Show information of a product
                4. Quit program 
                
                """);
        return choice.toLowerCase(Locale.ROOT);
    }
}
