import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03470_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path_to_directory"; // specify the directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}