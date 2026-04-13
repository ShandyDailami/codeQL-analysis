import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_38450_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            countLinesInDirectory(directory);
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void countLinesInDirectory(File directory) {
        int totalLines = 0;

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                Scanner fileScanner;
                try {
                    fileScanner = new Scanner(file);
                    int lineCount = 0;
                    while (fileScanner.hasNextLine()) {
                        fileScanner.nextLine();
                        lineCount++;
                    }
                    fileScanner.close();
                    totalLines += lineCount;
                    System.out.println("File: " + file.getName() + ", Lines: " + lineCount);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Total lines: " + totalLines);
    }
}