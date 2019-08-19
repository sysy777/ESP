import java.io.*;

import ESP.Alarm;
import ESP.Menu;

public class Main {

    public static void main(String[] args) {
        File f = new File("food.txt");

        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Alarm.alarm(f);
        Menu.menu(f);
    }
}


