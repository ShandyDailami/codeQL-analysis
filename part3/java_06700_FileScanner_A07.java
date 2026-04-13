import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_06700_FileScanner_A07 {
    private static final String DIRECTORY_PATH = "/path/to/directory";  // replace with your directory path
    private static final String FILE_EXTENSION = ".*\\.txt$";  // replace with your file extension

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.matches(FILE_EXTENSION));
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Perform security-sensitive operations related to authentication failure
                        // Here, we just print the line for simplicity
                        System.out.println(line);
                    }
                    scanner.close();
                });
            }
        } else {
            System.out.println("Directory does not exist or it's not a directory.");
        }
    }
}