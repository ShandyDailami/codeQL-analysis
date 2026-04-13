import java.io.File;
import java.util.Scanner;

public class java_37601_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    if ("pdf".equalsIgnoreCase(extension)) {
                        System.out.println("Processing file: " + file.getPath());
                        // TODO: Implement security-sensitive operations related to A08_IntegrityFailure
                    }
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }

        scanner.close();
    }
}