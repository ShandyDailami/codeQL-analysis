import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_02386_FileScanner_A08 {
    // This is a function that will read a directory and all its subdirectories
    public static List<String> readFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        List<String> fileNames = new ArrayList<>();

        // If the directory does not exist, return an empty list
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return fileNames;
        }

        // Get all files in the directory and its subdirectories
        File[] files = directory.listFiles();

        // If files is not null, iterate through them
        if (files != null) {
            for (File file : files) {
                // If file is not a directory and is a file (not a directory represents a file), add its name to the list
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }
        return fileNames;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        List<String> fileNames = readFilesInDirectory(directoryPath);

        if (fileNames.isEmpty()) {
            System.out.println("No files found");
        } else {
            System.out.println("Files in the directory:");
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        }
    }
}