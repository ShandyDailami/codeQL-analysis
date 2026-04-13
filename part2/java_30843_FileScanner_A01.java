import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30843_FileScanner_A01 {
    public static void main(String[] args) {
        String currentDir = new File(".").getAbsolutePath();
        scanDirectory(currentDir);
    }

    private static void scanDirectory(String dir) {
        File file = new File(dir);
        File[] listOfFiles = file.listFiles();

        for (File file1 : listOfFiles) {
            if (file1.isFile()) {
                System.out.println(file1.getAbsolutePath());
            } else if (file1.isDirectory()) {
                System.out.println(file1.getAbsolutePath());
                scanDirectory(file1.getAbsolutePath());
            }
        }
    }
}