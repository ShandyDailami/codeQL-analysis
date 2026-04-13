import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_31467_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.stream(files)
                        .filter(file -> file.isFile())
                        .map(File::getName)
                        .forEach(System.out::println);
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }

        scanner.close();
    }
}