import java.io.File;
import java.util.Scanner;

public class java_31408_FileScanner_A01 {

    public static void main(String[] args) {

        // Create a File object for the directory
        File directory = new File(".");

        // Use a recursive file listing
        listFilesAndFolders(directory, 0);
    }

    private static void listFilesAndFolders(File directory, int indent) {

        // Indicate the current depth of the directory
        for (int i = 0; i < indent; i++) {
            System.out.print("--");
        }
        System.out.println(directory.getName());

        // List all the files and directories in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If the file is a directory, list it and its contents
                    listFilesAndFolders(file, indent + 1);
                } else {
                    // If the file is a file, print it
                    for (int i = 0; i < indent + 1; i++) {
                        System.out.print("--");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}