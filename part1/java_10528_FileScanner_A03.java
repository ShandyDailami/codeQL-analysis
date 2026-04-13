import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10528_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory";  // replace with your directory path
        File directory = new File(directoryPath);
        File[] filesList = directory.listFiles();

        for (File file : filesList) {
            if (file.isFile()) {
                printFileInfo(file);
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getPath());
        System.out.println("File Absolute Path: " + file.getAbsolutePath());
        System.out.println("File Size in Bytes: " + file.length());
        System.out.println("File Last Modified: " + file.lastModified());
        System.out.println("-------------------------");
    }
}