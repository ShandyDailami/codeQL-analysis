import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09401_FileScanner_A01 {

    public static void main(String[] args) {

        File directory = new File(".");
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Unable to list directory contents.");
        }
    }
}