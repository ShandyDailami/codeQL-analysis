import java.io.File;
import java.util.Scanner;

public class java_13075_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("File found: " + file.getPath());
            } else {
                System.out.println("The path specified does not exist or it is not a file: " + file.getPath());
            }
        } else {
            System.out.println("The path specified does not exist: " + directoryPath);
        }

        scanner.close();
    }
}