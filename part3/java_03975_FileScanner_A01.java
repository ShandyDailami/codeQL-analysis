import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03975_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";

        File directory = new File(directoryPath);

        // Ensure the directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}