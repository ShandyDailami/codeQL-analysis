import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16201_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "C:\\path\\to\\directory";  // Insert your directory path here
        String fileExtension = ".*";  // Insert your file extension here, e.g. .txt

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Add security-sensitive operations here
                        // e.g., check for a specific keyword in the line
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}