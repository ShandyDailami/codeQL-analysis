import java.io.File;
import java.util.Scanner;

public class java_03377_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.next();
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.next();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (file.exists()) {
            System.out.println("File found: " + file.getPath());
        } else {
            System.out.println("File not found.");
        }
    }
}