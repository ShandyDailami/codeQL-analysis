import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41103_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        String fileExtension = ".txt"; // Replace with your file extension

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);

                        // Simulating security-sensitive operations
                        // For example, checking if the line contains a password or similar sensitive information
                        if (line.contains("password")) {
                            System.out.println("Found a password in the file: " + file.getName());
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}