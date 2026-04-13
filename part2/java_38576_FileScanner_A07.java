import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38576_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        // Prompt the user to enter a directory path
        System.out.println("Please enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String dirPath = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(dirPath);

        // Create a File object for each file in the directory
        File[] files = dir.listFiles();

        // Check if there are any files in the directory
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Print the file name
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("The directory does not exist or is empty.");
        }
    }
}