import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08997_FileScanner_A08 {

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File dir = new File(currentDir);

        File[] listOfFiles = dir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    printFileDetails(file);
                }
            }
        }
    }

    public static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getAbsolutePath());
        System.out.println("File Size: " + file.length() + " bytes");
    }
}