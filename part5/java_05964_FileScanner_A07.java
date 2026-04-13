import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_05964_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files)
                        .filter(file -> file.isFile() && file.canRead())
                        .forEach(file -> System.out.println("File: " + file.getName()));
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The specified path is not a directory.");
        }
    }
}