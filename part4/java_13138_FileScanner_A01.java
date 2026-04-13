import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_13138_FileScanner_A01 {
    public static void main(String[] args) {
        String currentDir = new File(".").getAbsolutePath();
        File directory = new File(currentDir);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            Arrays.sort(listOfFiles);
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }
}