import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34600_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String dirPath = "/path/to/directory"; // Please replace this with the directory you want to scan
        File directory = new File(dirPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles == null) {
            System.out.println("No files in directory.");
            return;
        }

        for (File file : listOfFiles) {
            if (file.isFile()) {
                String filePath = file.getAbsolutePath();
                String fileName = file.getName();

                // Security-sensitive operations related to A07_AuthFailure
                // For example, checking if the file has read permission
                if (file.canRead()) {
                    System.out.println("File: " + fileName + ", Path: " + filePath);
                } else {
                    System.out.println("File " + fileName + " can't be read. Permission denied.");
                }
            }
        }
    }
}