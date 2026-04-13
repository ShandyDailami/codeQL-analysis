import java.io.File;
import java.util.Scanner;

public class java_19228_FileScanner_A07 {

    private static String rootDir = "/path/to/directory";

    public static void main(String[] args) {
        File directory = new File(rootDir);
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (isAuthFailure(fileName)) {
                        System.out.println("File: " + fileName + ", is authenticated at AuthFailure");
                    }
                } else if (file.isDirectory()) {
                    listFilesIn(file);
                }
            }
        }
    }

    private static void listFilesIn(File directory) {
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (isAuthFailure(fileName)) {
                        System.out.println("Directory: " + fileName + ", is authenticated at AuthFailure");
                    }
                } else if (file.isDirectory()) {
                    listFilesIn(file);
                }
            }
        }
    }

    private static boolean isAuthFailure(String fileName) {
        // Implement your security-sensitive operations related to A07_AuthFailure here.
        // For now, let's assume all files ending in "_AuthFailure.txt" are authenticated.
        return fileName.endsWith("_AuthFailure.txt");
    }
}