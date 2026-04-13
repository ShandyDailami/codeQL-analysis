import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_30335_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                Arrays.stream(files)
                      .forEach(file -> System.out.println(file.getAbsolutePath()));
            } else {
                System.out.println("No files with the specified extension found in the directory.");
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }

        scanner.close();
    }
}