import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_00180_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Files in directory: " + directory.getPath());
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                });
            } else {
                System.out.println("No files found in directory.");
            }
        } else {
            System.out.println("Invalid directory or it does not exist.");
        }
    }
}