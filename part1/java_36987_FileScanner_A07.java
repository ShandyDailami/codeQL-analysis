import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36987_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
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
                System.out.println("Directory does not exist or no read permissions.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}