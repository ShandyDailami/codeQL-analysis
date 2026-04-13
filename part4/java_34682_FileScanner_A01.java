import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34682_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File name: " + file.getName());
                }
            }
        } else {
            System.out.println("Directory is not found!");
        }
    }
}