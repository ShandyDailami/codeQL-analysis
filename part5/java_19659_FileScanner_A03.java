import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19659_FileScanner_A03 {

    public static void main(String[] args) {

        // Get the current directory
        File currentDir = new File(".");

        // Scan the current directory
        scanDirectory(currentDir);
    }

    private static void scanDirectory(File dir) {

        // Get all files in the directory
        File[] files = dir.listFiles();

        // Check if files exists
        if (files != null) {

            // For each file in the directory
            for (File file : files) {

                // Check if file is directory
                if (file.isDirectory()) {

                    // Recursive call
                    scanDirectory(file);
                } else {

                    // Check if file is text file
                    if (file.getName().endsWith(".txt")) {

                        // Try to open the file
                        try (Scanner scanner = new Scanner(file)) {

                            // While there are more lines to read
                            while (scanner.hasNextLine()) {

                                // Print the line
                                System.out.println(scanner.nextLine());
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}