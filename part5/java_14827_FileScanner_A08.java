import java.io.File;
import java.util.Scanner;

public class java_14827_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        countLinesInDirectory(new File(directoryPath));
    }

    public static void countLinesInDirectory(File directory) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                countLinesInFile(file);
            }
        } else {
            System.out.println("Not a directory: " + directory.getAbsolutePath());
        }
    }

    public static void countLinesInFile(File file) {
        if (file.isFile() && file.canRead()) {
            try (Scanner scanner = new Scanner(file)) {
                int lineCount = 0;
                while (scanner.hasNextLine()) {
                    scanner.nextLine();
                    lineCount++;
                }
                System.out.println("File: " + file.getAbsolutePath() + " has " + lineCount + " lines");
            }
        } else {
            System.out.println("Not a readable file: " + file.getAbsolutePath());
        }
    }
}