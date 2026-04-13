import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class java_19892_FileScanner_A08 {

    public static void main(String[] args) {

        // Prompt for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the regex pattern: ");
        String pattern = scanner.nextLine();

        // Create a pattern object
        Pattern filePattern = Pattern.compile(pattern);

        // Get a file object
        File directory = new File(directoryPath);

        // List all files in the directory
        File[] files = directory.listFiles();

        // If no files found, print message
        if (files == null) {
            System.out.println("No files found in the directory");
            return;
        }

        // Print all files that match the pattern
        for (File file : files) {
            if (file.isFile()) {
                Matcher matcher = filePattern.matcher(file.getName());
                if (matcher.matches()) {
                    System.out.println(file.getPath());
                }
            }
        }
    }
}