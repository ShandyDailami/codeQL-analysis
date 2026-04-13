import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01411_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File(".");

        // Scan directory for files
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                }
            }
        }
    }
}