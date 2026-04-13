import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21480_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileName(file);
                }
            }
        }
    }

    private static void printFileName(File file) {
        System.out.println("File name: " + file.getName());
    }
}