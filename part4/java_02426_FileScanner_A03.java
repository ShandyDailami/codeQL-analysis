import java.io.File;
import java.util.Scanner;

public class java_02426_FileScanner_A03 {
    public static void main(String[] args) {
        // Get the current directory
        File currentDir = new File(".");

        // Scan all files in the current directory
        for (File file : currentDir.listFiles()) {
            // Check if the file is a regular file (not a directory or a device)
            if (file.isFile() && file.canRead()) {
                try (Scanner scanner = new Scanner(file)) {
                    // Print the contents of the file
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                }
            }
        }
    }
}