import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_20715_FileScanner_A07 {
    public static void main(String[] args) {
        String dir = "."; // Change this to the directory you want to scan.
        FileScanner(dir);
    }

    private static void FileScanner(String dir) {
        File file = new File(dir);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(Main::printFileDetails);
            }
        }
    }

    private static void printFileDetails(File file) {
        if (file.isFile()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("File Path: " + file.getPath());
            System.out.println("File Size: " + file.length() + " bytes");
        }
    }
}