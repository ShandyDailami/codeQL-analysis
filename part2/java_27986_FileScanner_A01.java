import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27986_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = input.next();
        scanDirectory(dirPath);
    }

    private static void scanDirectory(String dirPath) {
        File directory = new File(dirPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    scanDirectory(file.getPath());
                }
            }
        }
    }
}