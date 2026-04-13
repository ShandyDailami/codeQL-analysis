import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23521_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("Error: Unable to list files in the directory");
            }
        } else {
            System.out.println("Error: Directory does not exist");
        }
    }
}