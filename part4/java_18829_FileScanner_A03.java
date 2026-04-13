import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_18829_FileScanner_A03 {
    private static final String DIRECTORY = "C:\\path\\to\\directory"; // Change this to the directory you want to scan
    private static final String FILE_EXTENSION = ".*\\.txt$"; // Change this to the file extension you want to scan

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] listOfFiles = directory.listFiles((dir, name) -> name.matches(FILE_EXTENSION));
        if (listOfFiles != null) {
            Arrays.stream(listOfFiles).forEach(file -> {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Here you can add your security-sensitive operations related to injection, such as SQL injection prevention.
                        // For instance, you can check if the line contains a string that could be used for SQL injection.
                    }
                    scanner.close();
                }
            });
        }
    }
}