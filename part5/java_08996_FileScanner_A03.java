import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_08996_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null && files.length > 0) {
                Arrays.stream(files)
                      .filter(file -> file.isFile())
                      .forEach(file -> printFileDetails(file));
            } else {
                System.out.println("No files found in the directory.");
            }

            scanner.close();
        } else {
            System.out.println("Invalid directory path or path does not exist.");
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getPath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("--------------------");
    }
}