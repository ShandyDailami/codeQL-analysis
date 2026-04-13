import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25300_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the list of directories to scan.
        File[] roots = File.listRoots();

        // Print out the list of directories.
        for (File file : roots) {
            System.out.println("Scanning directory: " + file.getAbsolutePath());

            // Get the list of files in the directory.
            File[] list = file.listFiles();

            // Print out the list of files.
            for (File f : list) {
                if (f.isFile()) {
                    System.out.println(" -> File: " + f.getName() + " (" + f.length() + " bytes)");
                } else if (f.isDirectory()) {
                    System.out.println(" -> Directory: " + f.getName());
                }
            }
        }
    }
}