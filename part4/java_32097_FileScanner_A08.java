import java.io.File;
import java.util.Scanner;

public class java_32097_FileScanner_A08 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current directory: " + currentDir);

        File dir = new File(currentDir);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
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