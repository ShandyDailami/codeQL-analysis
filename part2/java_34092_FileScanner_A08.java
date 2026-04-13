import java.io.File;
import java.util.Scanner;

public class java_34092_FileScanner_A08 {

    public static void main(String[] args) {
        // Define a directory
        File dir = new File(".");

        // Initialize a scanner for reading files
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Scan the directory for files
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Print the content of the file
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                    }
                }
            }
        }
    }
}