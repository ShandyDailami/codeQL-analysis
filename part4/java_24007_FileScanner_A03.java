import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_24007_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace this with your directory path

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        System.out.println("File Name: " + file.getName());
                        System.out.println("File Path: " + file.getPath());
                        System.out.println("File Absolute Path: " + file.getAbsolutePath());
                        System.out.println("File Size: " + file.length() + " bytes");
                    } else if (file.isDirectory()) {
                        System.out.println("Directory Name: " + file.getName());
                        System.out.println("Directory Path: " + file.getPath());
                        System.out.println("Directory Absolute Path: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}