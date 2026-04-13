import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36085_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "./test-dir"; // Specify your directory path here
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                }
            }
        }
    }
}