import java.io.File;
import java.util.Scanner;

public class java_35222_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().contains("integrity")) {
                    System.out.println("File: " + file.getName());
                }
            }
        }

        scanner.close();
    }
}