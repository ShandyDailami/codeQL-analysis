import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_22148_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object to represent a directory
        File directory = new File(".");

        // Use the FileScanner to list the contents of the directory
        File[] list = directory.listFiles();
        if (list != null) {
            Arrays.sort(list);
            for (File f : list) {
                System.out.println(f.getName());
            }
        }

        // Ask for a filename
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a filename:");
        String filename = scanner.nextLine();

        // Check if the filename exists
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }

        // Close the scanner
        scanner.close();
    }
}