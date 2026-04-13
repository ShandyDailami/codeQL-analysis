import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18666_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileInfo(file);
                    }
                }
            }
        } else {
            System.out.println("The directory does not exist");
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length() + " bytes");
    }
}