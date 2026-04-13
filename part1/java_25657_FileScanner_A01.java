import java.io.File;
import java.util.Scanner;

public class java_25657_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File rootDirectory = new File(path);

        listFiles(rootDirectory);
    }

    private static void listFiles(File directory) {
        // Get all files and directories
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If the file is a directory, list its contents
                    listFiles(file);
                } else {
                    // If the file is a file, print its name
                    System.out.println(file.getName());
                }
            }
        }
    }
}