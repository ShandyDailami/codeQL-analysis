import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12393_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the current directory
        File currentDir = new File(".");

        // Scan all files in the current directory and its subdirectories
        File[] allFiles = currentDir.listFiles();
        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
                    // Print out the content of the file
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    }
                }
            }
        }
    }
}