import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class java_07938_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = args[0];
        File directory = new File(directoryPath);

        if (directory.exists()) {
            printDirectorySummary(directory);
        } else {
            System.out.println("Directory not found!");
        }
    }

    private static void printDirectorySummary(File directory) {
        long totalSize = 0;
        int totalLines = 0;

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                Path filePath = Paths.get(file.getPath());
                long fileSize = file.length();
                int lines = readFileAndCountLines(filePath, fileSize);

                System.out.println("File: " + file.getName());
                System.out.println("Size: " + fileSize + " bytes");
                System.out.println("Lines: " + lines);
                System.out.println("---------------------");

                totalSize += fileSize;
                totalLines += lines;
            }
        }

        System.out.println("Total size: " + totalSize + " bytes");
        System.out.println("Total lines: " + totalLines);
    }

    private static int readFileAndCountLines(Path filePath, long fileSize) {
        int lines = 0;
        try (Scanner scanner = new Scanner(filePath.toFile())) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + filePath);
        }

        return lines;
    }
}