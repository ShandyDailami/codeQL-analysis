import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28581_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory not found!");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        for (File file : files) {
            if (!file.isDirectory()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(file.getName() + " - " + line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getName());
                }
            }
        }
    }
}