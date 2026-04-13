import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31766_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File(".");
        countLinesInDirectory(file, "");
    }

    private static void countLinesInDirectory(File directory, String prefix) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursive call for directories
                    countLinesInDirectory(file, prefix + " -> ");
                } else if (file.isFile() && file.getName().endsWith(".txt")) {
                    // Count lines in txt files
                    try (Scanner scanner = new Scanner(file)) {
                        int lineCount = 0;
                        while (scanner.hasNextLine()) {
                            lineCount++;
                            scanner.nextLine();
                        }
                        System.out.println(prefix + file.getName() + ": " + lineCount + " lines");
                    } catch (FileNotFoundException e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                }
            }
        }
    }
}