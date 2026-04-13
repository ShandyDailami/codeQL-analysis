import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18005_FileScanner_A01 {
    public static void main(String[] args) {
        String dirPath = "C:\\Users\\YourUser\\YourDirectory"; // replace with your directory path
        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    }
                }
            } else {
                System.out.println("Directory is empty");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}