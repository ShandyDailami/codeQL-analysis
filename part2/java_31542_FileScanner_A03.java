import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31542_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = input.nextLine();
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else {
                    System.out.println("Directory: " + file.getPath());
                }
            }
        } else {
            System.out.println("Directory not found!");
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length() + " bytes");
    }
}