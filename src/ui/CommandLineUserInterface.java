package ui;

import java.util.Scanner;

public class CommandLineUserInterface extends UserInterface {

    @Override
    public boolean output(String message) {
        System.out.println(message);
        return true;
    }

    @Override
    public String readStr() {
        Scanner strScanner = new Scanner(System.in);
        String str;
        str = strScanner.nextLine();
        return str;
    }

    @Override
    public int readInt() {
        Scanner intScanner = new Scanner(System.in);
        int number;
        number = intScanner.nextInt();
        return number;
    }
}