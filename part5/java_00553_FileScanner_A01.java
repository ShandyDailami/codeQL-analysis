import java.io.*;

public class java_00553_FileScanner_A01 {

    public static void main(String[] args) {

        // Specify the directory to scan
        String directory = "/path/to/directory";

        // Use the File class to get an instance of the file object
        File file = new File(directory);

        // Use a recursive method to get all the files in the directory
        getFiles(file);
    }

    // Recursive method to get all files in a directory
    private static void getFiles(File file) {
        // Get an array of all files in the directory
        File[] files = file.listFiles();

        // If files exists, loop through them
        if (files != null) {
            for (File f : files) {
                // If the file is a directory, call the method recursively
                if (f.isDirectory()) {
                    getFiles(f);
                } else {
                    // If the file is a regular file, print its name
                    System.out.println(f.getName());
                }
            }
        }
    }
}