import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_13259_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a new File object
        File file = new File("/path/to/your/directory");

        // Use the File object to list all the files in the directory
        String[] fileList = file.list();

        // Print the file list
        if (fileList != null) {
            Arrays.sort(fileList);
            for (String filename : fileList) {
                System.out.println(filename);
            }
        } else {
            System.out.println("No files found in the directory");
        }
    }
}