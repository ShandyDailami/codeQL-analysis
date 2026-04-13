import java.io.File;
import java.util.Scanner;

public class java_33636_FileScanner_A07 {
    public static void main(String[] args) {
        String searchString = "AuthFailure";
        File directory = new File(".");

        // FileScanner will only scan files in the current directory
        File[] foundFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        // No files found with the given string
        if (foundFiles == null) {
            System.out.println("No .txt files found with the string 'AuthFailure'");
            return;
        }

        for (File file : foundFiles) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(searchString)) {
                        System.out.println("Found the string 'AuthFailure' in the file: " + file.getAbsolutePath());
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading the file: " + file.getAbsolutePath());
            }
        }
    }
}