import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10462_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        long totalSize = 0;
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    totalSize += file.length();
                }
            }
        }

        System.out.println("Total size of files in " + directoryPath + " is " + totalSize + " bytes.");
    }
}