import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_18228_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The specified directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("The specified path is not a directory.");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (!file.isHidden()) {
                    System.out.println(file.getName());
                }
            });
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}