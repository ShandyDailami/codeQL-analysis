import java.io.File;
import java.util.Scanner;

public class java_16671_FileScanner_A01 {
    private final Scanner scanner;

    public java_16671_FileScanner_A01(Scanner scanner) {
        this.scanner = scanner;
    }

    public void scanDirectory(String directoryPath, String fileName) {
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File file = new File(directory, fileName);

            if (file.exists()) {
                System.out.println("File found: " + file.getAbsolutePath());
            } else {
                System.out.println("File not found: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory does not exist or is not a directory: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileScanner fileScanner = new FileScanner(scanner);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        fileScanner.scanDirectory(directoryPath, fileName);
    }
}