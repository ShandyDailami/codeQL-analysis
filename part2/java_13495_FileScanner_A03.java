import java.io.File;
import java.util.Scanner;

public class java_13495_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("."); // Use current directory

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Files in directory: " + file.getName());

                File[] listOfFiles = file.listFiles();

                for (File file1 : listOfFiles) {
                    if (file1.isFile()) {
                        System.out.println("File: " + file1.getName());
                    } else if (file1.isDirectory()) {
                        System.out.println("Directory: " + file1.getName());
                    }
                }
            } else {
                System.out.println("Not a directory");
            }
        } else {
            System.out.println("File not found");
        }
    }
}