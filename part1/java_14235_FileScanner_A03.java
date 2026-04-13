import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14235_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        File[] allFiles = directory.listFiles();
        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
                    countLinesInFile(file);
                }
            }
        }
    }

    private static void countLinesInFile(File file) {
        int lineCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }

        System.out.println("File: " + file.getPath() + ", Lines: " + lineCount);
    }
}