import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03297_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {

        // Set the directory to scan
        File dir = new File("your_directory_path");

        // Use the FileScanner to list all files in the directory
        Scanner scanner = new Scanner(dir);
        while (scanner.hasNext()) {
            File file = scanner.nextFile();

            // Print file name and permission bits
            System.out.println("File: " + file.getName() + ", Permission bits: " + Integer.toBinaryString(file.canRead() ? file.readable() : 0));
        }
        scanner.close();
    }
}