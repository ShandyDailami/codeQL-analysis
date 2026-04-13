import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15109_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory";

        File directory = new File(directoryPath);

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    printFileInfo(file);
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getAbsolutePath());
        System.out.println("File Size: " + file.length() + " bytes");
    }
}