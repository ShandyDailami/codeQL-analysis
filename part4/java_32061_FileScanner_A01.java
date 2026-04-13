import java.io.File;
import java.util.Scanner;

public class java_32061_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.next();

        System.out.println("Please enter the file extension:");
        String fileExtension = scanner.next();

        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found with the extension: " + fileExtension);
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}