import java.io.File;
import java.util.Scanner;

public class java_15480_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter file extension:");
        String fileExtension = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No files found with extension: " + fileExtension);
            }
        } else {
            System.out.println("Invalid directory");
        }
    }
}