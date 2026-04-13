import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01124_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files or directories found!");
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}