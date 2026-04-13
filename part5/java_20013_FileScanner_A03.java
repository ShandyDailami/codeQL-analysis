import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20013_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            int lineCount = 0;
                            while (scanner.hasNextLine()) {
                                scanner.nextLine();
                                lineCount++;
                            }
                            System.out.println("File: " + file.getName() + ", Lines: " + lineCount);
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}