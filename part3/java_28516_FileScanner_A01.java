import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28516_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // Get the current directory
        String[] list = directory.list();

        // Print out the names and sizes of all files in the directory
        for (String name : list) {
            File file = new File(name);
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
                System.out.println("Size: " + file.length() + " bytes");
                System.out.println("------------------------");
            }
        }
    }
}