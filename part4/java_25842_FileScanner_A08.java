import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25842_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            try {
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile() && file.canRead()) {
                            readFile(file);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error occurred while accessing directory: " + e.getMessage());
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Security-sensitive operation, e.g., logging or error checking
                System.out.println("Processing line: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}