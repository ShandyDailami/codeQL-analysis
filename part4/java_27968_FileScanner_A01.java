import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27968_FileScanner_A01 {
    private static final String SECURITY_WARNING = "WARNING: This operation may be seen as breaking access control.";

    private java_27968_FileScanner_A01() {}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = input.nextLine();

        // Ensure the directory exists.
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (directory.isDirectory()) {
            // List all files in the directory.
            System.out.println("Here are all files in the directory:");
            listFiles(directory, "");
        } else {
            System.out.println("The provided path is not a directory.");
        }

        input.close();
    }

    private static void listFiles(File directory, String indentation) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // This file is a directory, recursively list it.
                    listFiles(file, indentation + "  ");
                } else {
                    // This file is a file, print its name.
                    System.out.println(indentation + file.getName());
                }
            }
        }
    }
}