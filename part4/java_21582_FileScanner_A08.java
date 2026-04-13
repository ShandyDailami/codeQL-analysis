import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21582_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}