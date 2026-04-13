import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_28137_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();

                if (files != null) {
                    Arrays.stream(files)
                            .filter(file -> file.isFile())
                            .forEach(file -> System.out.println(file.getName()));
                } else {
                    System.out.println("No files in the directory.");
                }
            } else {
                System.out.println("Not a directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}