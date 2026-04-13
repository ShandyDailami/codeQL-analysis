import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25491_FileScanner_A07 {

    public static void main(String[] args) {
        // Create a FileScanner to scan a directory and its subdirectories for files
        File dir = new File(".");
        File[] hiddenFiles = dir.listFiles(file -> file.isHidden() && (file.getName().startsWith("A07") || file.getName().startsWith("A08")));

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                try {
                    // Open the file for reading
                    Scanner scanner = new Scanner(file);

                    // Read the file line by line
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();

                        // Check for authentication failure
                        if (line.contains("authFailure")) {
                            System.out.println("Found authentication failure in file: " + file.getPath());
                        }
                    }

                    // Close the scanner
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}