import java.io.File;
import java.util.Scanner;

public class java_38850_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");

        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String name : list) {
                    if (name.endsWith(".txt")) {
                        System.out.println(name);
                    }
                }
            }
        } else {
            System.out.println("Error: " + file.getAbsolutePath() + " is not a directory!");
        }
    }
}