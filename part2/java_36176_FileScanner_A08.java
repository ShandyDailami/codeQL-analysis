import java.io.File;
import java.util.Arrays;

public class java_36176_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File(".");

        // Using listFiles() method to get all files and directories in the current directory
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    // If the file is a regular file, print its name and size
                    System.out.println("File: " + f.getName() + ", Size: " + f.length() + " bytes");
                } else if (f.isDirectory()) {
                    // If the file is a directory, print its name
                    System.out.println("Directory: " + f.getName());
                }
            }
        }
    }
}