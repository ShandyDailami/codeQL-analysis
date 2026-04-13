import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_09366_FileScanner_A08 {
    public static void main(String[] args) {
        Set<String> uniqueFileNames = new HashSet<>();
        String directoryPath = "path/to/directory"; // Replace with your directory path

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] allFiles = directory.listFiles();
        if (allFiles == null) {
            System.out.println("No files in the directory!");
            return;
        }

        for (File file : allFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (uniqueFileNames.add(fileName)) {
                    System.out.println("Unique file: " + fileName);
                } else {
                    System.out.println("Duplicate file: " + fileName);
                }
            }
        }
    }
}