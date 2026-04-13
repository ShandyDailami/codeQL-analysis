import java.io.*;
import java.util.*;

public class java_00083_FileScanner_A03 {

    private static final String DIRECTORY = "path_to_directory"; // Replace with your directory

    public static void main(String[] args) {
        File dir = new File(DIRECTORY);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && isFileSafe(file)) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }

    private static boolean isFileSafe(File file) {
        // TODO: Add your security-sensitive operations here
        // For now, let's assume it's safe
        return true;
    }
}