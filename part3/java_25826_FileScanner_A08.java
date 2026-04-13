import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25826_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // specify your directory here
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("Unable to list files in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}