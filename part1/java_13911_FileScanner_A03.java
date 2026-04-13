import java.io.File;
import java.util.Scanner;

public class java_13911_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (file.exists()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}