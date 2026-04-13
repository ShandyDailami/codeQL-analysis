import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36568_FileScanner_A03 {

    public static void main(String[] args) {
        String currentDir = new File(".").getAbsolutePath();
        scanDirectory(currentDir);
    }

    private static void scanDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file.getAbsolutePath());
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println(file.getAbsolutePath());
    }
}