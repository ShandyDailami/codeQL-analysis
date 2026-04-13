import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29289_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        countFilesAndLinesInDirectory(directory);
    }

    public static void countFilesAndLinesInDirectory(File directory) {
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        int lineCount = 0;
                        while (scanner.hasNextLine()) {
                            scanner.nextLine();
                            lineCount++;
                        }
                        System.out.println("File: " + file.getName() + ", Lines: " + lineCount);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}