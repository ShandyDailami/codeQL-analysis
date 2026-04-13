import java.io.File;
import java.util.Scanner;

public class java_29725_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the file name:");
        String fileName = scanner.next();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (file.exists()) {
            System.out.println("File found: " + file.getAbsolutePath());
        } else {
            System.out.println("File not found");
        }

        scanner.close();
    }
}