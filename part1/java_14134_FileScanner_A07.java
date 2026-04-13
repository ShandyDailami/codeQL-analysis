import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14134_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // provide your directory path here

        File directory = new File(directoryPath);

        if (directory.exists()) {
            countFilesAndFolders(directory);
        } else {
            System.out.println("Directory not found");
        }
    }

    private static void countFilesAndFolders(File directory) throws FileNotFoundException {
        int totalFiles = 0;
        int totalFolders = 0;

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                totalFiles++;
            } else if (file.isDirectory()) {
                totalFolders++;
                countFilesAndFolders(file);
            }
        }

        System.out.println("Total files: " + totalFiles);
        System.out.println("Total directories: " + totalFolders);
    }
}