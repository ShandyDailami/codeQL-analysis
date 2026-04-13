import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12944_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory you want to scan
        File directory = new File(".");

        // Use a FileScanner to get all the files in the directory
        File[] files = directory.listFiles();

        // Loop through all the files
        for (File file : files) {
            // If the file is a directory, print out its name
            if (file.isDirectory()) {
                System.out.println(file.getName());
            }
        }
    }
}