import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34067_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";  // Replace with your directory
        String fileExtension = ".txt";  // Replace with your file extension

        File directoryFile = new File(directory);

        if (directoryFile.exists() && directoryFile.isDirectory()) {
            File[] files = directoryFile.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();

                            // Here you should perform your security-sensitive operations
                            // For example, we are scanning for SQL Injection attempts
                            if (line.contains("' OR '1'='1")) {
                                System.out.println("Found SQL Injection attempt in file: " + file.getName());
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory");
        }
    }
}