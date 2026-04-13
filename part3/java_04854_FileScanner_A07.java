import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_04854_FileScanner_A07 {
    private static final String INPUT_DIRECTORY = "path_to_directory"; // replace with your directory path
    private static final String FILE_EXTENSION = "extension"; // replace with your file extension

    public static void main(String[] args) {
        File directory = new File(INPUT_DIRECTORY);
        File[] listOfFiles = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(FILE_EXTENSION);
            }
        });

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println("File Name: " + file.getName());
                // Add more security-sensitive operations here. For example, checking if the file is readable and executable.
                // You can also use a Scanner to read the file content for security-sensitive operations.
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Add more security-sensitive operations here. For example, checking for SQL injection attacks.
                    // You can also use Java's classes for performing string manipulations.
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}