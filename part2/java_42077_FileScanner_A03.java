import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_42077_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Specify directory path
        String fileExtension = "txt"; // Specify file extension

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Perform security-sensitive operations related to injection
                            // You can use the appropriate security measures here like parameterized queries, cross-site scripting, etc.
                            System.out.println("Found file: " + file.getPath() + " - Line: " + line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            } else {
                System.out.println("No files with the extension: " + fileExtension + " in the directory: " + directory.getPath());
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory: " + directory.getPath());
        }
    }
}