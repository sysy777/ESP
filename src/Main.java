import java.io.*;

import ESP.Menu;

public class Main {

    public static void main(String[] args) {
        File f = new File("food.txt");
        Menu.menu(f);
    }
}


