import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_02971_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    } else if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    }
                });
            } else {
                System.out.println("No files or directories found in the specified directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}