import java.io.File;
import java.util.Scanner;

public class java_25470_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.equals(fileName));

        if (files != null && files.length > 0) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}