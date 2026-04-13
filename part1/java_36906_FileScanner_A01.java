import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36906_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] list = directory.list();

        if (list != null) {
            for (String file : list) {
                System.out.println(file);
            }
        } else {
            System.out.println("The directory is empty.");
        }
    }
}