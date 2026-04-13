import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_33991_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files found!");
            System.exit(1);
        }

        Arrays.stream(files).forEach(file -> {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            }
        });
    }
}