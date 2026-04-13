import java.io.File;
import java.util.Scanner;

public class java_00218_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No files found with extension: " + fileExtension);
        }

        scanner.close();
    }
}