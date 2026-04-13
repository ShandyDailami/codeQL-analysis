import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41388_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (directory.listFiles() == null) {
            System.out.println("No files in the directory");
            return;
        }

        System.out.println("Files in the directory:");
        listFiles(directory, "");
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    listFiles(file, indent + "  ");
                } else {
                    System.out.println(indent + "- File: " + file.getName());
                }
            }
        }
    }
}