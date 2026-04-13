import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40774_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".*.txt"; // replace with your file extension

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // You can perform a security-sensitive operation here,
                        // such as parsing the input and performing operations based on it.
                        // For example, you could print the line to console:
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                }
            }
        }
    }
}