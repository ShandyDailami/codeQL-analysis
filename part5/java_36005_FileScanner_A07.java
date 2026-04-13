import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36005_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        countFiles(directory);
    }

    public static void countFiles(File directory) {
        int totalLines = 0;
        if (directory.listFiles().length == 0) {
            System.out.println("No files found");
            return;
        }
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        totalLines++;
                        scanner.nextLine();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getAbsolutePath());
                }
            } else if (file.isDirectory()) {
                countFiles(file);
            }
        }
        System.out.println("Total lines: " + totalLines);
    }
}