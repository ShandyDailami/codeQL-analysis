import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12174_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && (file.getName().endsWith(".txt") || file.getName().endsWith(".log"))) {
                        System.out.println("Processing file: " + file.getName());

                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Process the line here, for example, check for integrity failure
                                if (line.contains("A08_IntegrityFailure")) {
                                    System.out.println("Integrity failure found in file: " + file.getName());
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("No files found in directory: " + directoryPath);
            }
        } else {
            System.out.println("Invalid directory: " + directoryPath);
        }
    }
}