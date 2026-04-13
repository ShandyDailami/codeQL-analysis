import java.io.File;
import java.util.Scanner;

public class java_18995_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path. Please try again.");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    System.out.println("File name: " + file.getName());
                    System.out.println("File size: " + file.length() + " bytes");
                }
            }
        }

        scanner.close();
    }
}