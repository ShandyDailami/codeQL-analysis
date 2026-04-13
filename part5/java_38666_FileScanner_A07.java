import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38666_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with actual directory path
        countLinesInDirectory(new File(directoryPath));
    }

    private static void countLinesInDirectory(File directory) {
        int totalLines = 0;

        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile() && isFileSafe(file)) {
                    totalLines += countLinesInFile(file);
                } else if (file.isDirectory()) {
                    totalLines += countLinesInDirectory(file);
                }
            }
        }

        System.out.println("Total lines: " + totalLines);
    }

    private static boolean isFileSafe(File file) {
        // Implement security-sensitive operations related to A07_AuthFailure here
        // e.g., check file permissions, read/write to/from file
        // return true if file is safe, false otherwise
    }

    private static int countLinesInFile(File file) {
        int totalLines = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                totalLines++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }

        return totalLines;
    }
}