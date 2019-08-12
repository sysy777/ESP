import java.io.*;

import ESP.DataStructure.FoodBlock;
import ESP.Menu;


public class Main {
    public static final int SIZE = 10;
    FoodBlock[] myRef = new FoodBlock[SIZE]; //음식물개수

    public static void main(String[] args) {
        File f = new File("food.txt");

        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Menu.menu(f);
    }
}


