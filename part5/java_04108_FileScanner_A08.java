import java.io.File;
import java.util.Scanner;

public class java_04108_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the file name:");
        String fileName = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (file.exists() && file.isFile() && file.canRead()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found or not accessible!");
        }
    }
}