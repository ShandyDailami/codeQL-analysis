import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_06654_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                });
            } else {
                System.out.println("The directory does not exist or it is not a directory.");
            }
        } else {
            System.out.println("The provided path does not exist or it is not a directory.");
        }
    }
}