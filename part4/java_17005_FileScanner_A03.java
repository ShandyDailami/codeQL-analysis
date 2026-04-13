import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17005_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";  // Replace with your directory path
        scanFiles(directory);
    }

    private static void scanFiles(String directory) {
        File[] files = new File(directory).listFiles((dir, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Perform security-sensitive operation (e.g., injection attack) here
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getAbsolutePath());
                }
            }
        }
    }
}