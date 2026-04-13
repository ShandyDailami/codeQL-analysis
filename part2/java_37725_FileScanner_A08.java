import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_37725_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] securitySensitiveFiles = { /* list of files that are considered security-sensitive */ };

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.stream(files)
                      .filter(file -> !Arrays.asList(securitySensitiveFiles).contains(file))
                      .forEach(file -> System.out.println(file.getName()));
            } else {
                System.out.println("No files in the directory!");
            }
        } else {
            System.out.println("Invalid directory path!");
        }
    }
}