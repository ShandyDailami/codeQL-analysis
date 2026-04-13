import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22897_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {

        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

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
        System.out.println("File Name: " + file.getName());
    }
}