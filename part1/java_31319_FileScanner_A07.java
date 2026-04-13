import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31319_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();

                            // Example of a security-sensitive operation.
                            // This is a placeholder, replace with your actual operation.
                            if (line.contains("password")) {
                                System.out.println("Detected password in file: " + file.getName());
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                }
            }
        }
    }
}