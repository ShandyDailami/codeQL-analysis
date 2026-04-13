import java.io.File;
import java.util.Scanner;

public class java_04886_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);
        countLinesInDirectory(directory);
    }

    private static void countLinesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    countLinesInFile(file);
                } else if (file.isDirectory()) {
                    countLinesInDirectory(file);
                }
            }
        }
    }

    private static void countLinesInFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
            System.out.println("Number of lines in " + file.getName() + ": " + lineCount);
        } catch (Exception e) {
            System.out.println("Error occurred while processing " + file.getName());
        }
    }
}