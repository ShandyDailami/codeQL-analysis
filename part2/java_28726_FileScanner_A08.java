import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28726_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        // Check if directory exists and is accessible
        if (!directory.exists() || !directory.canRead()) {
            System.out.println("Invalid directory path or insufficient permissions.");
            return;
        }

        // Scan all .txt files in directory
        for (File file : directory.listFiles((dir, name) -> name.endsWith(".txt"))) {
            if (file.isFile()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error reading file: " + file.getPath());
                }
            }
        }
    }
}