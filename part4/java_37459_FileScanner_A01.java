import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37459_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        String fileExtension = ".*\\.txt$"; // Replace with your file extension

        File directory = new File(directoryPath);
        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));
            if (files != null) {
                for (File file : files) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}