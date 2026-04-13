import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_35628_FileScanner_A08 {

    // Method to check if a file is secure or not
    public static boolean isFileSecure(File file) {
        // Here you should implement the logic to check if a file is secure
        // For simplicity, let's assume a file is secure if it's not writable
        return !file.canWrite();
    }

    public static void main(String[] args) {
        // Change the directory and the file type accordingly
        File directory = new File("path_to_directory");
        String fileType = "extension_of_file";
        List<File> secureFiles = new ArrayList<>();

        // Use recursion to check all files in the directory
        checkDirectory(directory, fileType, secureFiles);

        // Print out all secure files
        for (File file : secureFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void checkDirectory(File directory, String fileType, List<File> secureFiles) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursive call to check subdirectories
                    checkDirectory(file, fileType, secureFiles);
                } else if (file.getName().endsWith(fileType) && isFileSecure(file)) {
                    // Add secure file to list
                    secureFiles.add(file);
                }
            }
        }
    }
}