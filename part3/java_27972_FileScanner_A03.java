import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27972_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // This will start in the same directory as the class

        // Use a try-with-resources statement to automatically close the scanner when it is no longer needed
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter the directory path:");
            String path = scanner.nextLine();

            // Use the new File object to get the directory and its files
            File filesDirectory = new File(path);
            File[] files = filesDirectory.listFiles();

            // Check if the directory exists and is accessible
            if (filesDirectory.exists() && filesDirectory.isDirectory()) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("Invalid directory path or no access to the directory.");
            }
        }
    }
}