import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_16533_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        System.out.println("Enter the file name:");
        String filename = scanner.nextLine();

        File directory = new File(path);
        File file = new File(directory, filename);

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        System.out.println("Reading file content:");
        FileScanner scannerInstance = new FileScanner(file);
        while (scannerInstance.hasNextLine()) {
            String line = scannerInstance.nextLine();
            System.out.println(line);
        }

        scannerInstance.close();
    }
}