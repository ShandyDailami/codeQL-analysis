import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11383_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the directory
        System.out.println("Enter the directory:");
        String dir = scanner.nextLine();

        // Get all files in the directory
        File file = new File(dir);
        File[] files = file.listFiles();

        // Print out the names of all files
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getName());
                }
            }
        }

        scanner.close();
    }
}