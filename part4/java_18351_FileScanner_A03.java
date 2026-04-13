import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_18351_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                    } else {
                        System.out.println("Directory: " + file.getName());
                    }
                });
            }
        } else {
            System.out.println("Directory does not exist or it's not a directory.");
        }
    }
}