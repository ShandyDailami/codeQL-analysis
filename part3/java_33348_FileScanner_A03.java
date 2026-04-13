import java.io.File;
import java.util.Scanner;

public class java_33348_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File(".");
        if (file.isDirectory()) {
            System.out.println("Files in the directory: ");
            String[] list = file.list();
            for (String name : list) {
                System.out.println(name);
            }
        } else {
            System.out.println("Error: " + file.getAbsolutePath() + " is not a directory.");
        }
    }
}