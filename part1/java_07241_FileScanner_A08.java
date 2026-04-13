import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07241_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Define the directory
        File directory = new File(".");

        // Scan files in the directory
        File[] listOfFiles = directory.listFiles();

        // Print out the names of all files in the directory
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}