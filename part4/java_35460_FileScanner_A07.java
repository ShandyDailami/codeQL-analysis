import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35460_FileScanner_A07 {

    public static void main(String[] args) {
        String dirPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(dirPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] listOfFiles = directory.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (!file.getName().startsWith(".")) {  // excludes hidden files
                        System.out.println(file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Could not list directory contents");
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }

    public static void handleException(Exception e) {
        if (e instanceof AuthFailureException) {
            System.out.println("Authentication failure. Please check your credentials.");
        } else {
            System.out.println("An error occurred while handling the exception: " + e.getMessage());
        }
    }
}