import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38327_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // The current directory

        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // Check if the directory is a file or a directory
        if (directory.isFile()) {
            System.out.println("It is not a directory");
            return;
        }

        // List all the files and directories in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    System.out.println(file.getName() + "/");
                }
            }
        }
    }
}