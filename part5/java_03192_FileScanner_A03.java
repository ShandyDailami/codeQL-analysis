import java.io.File;
import java.util.Scanner;

public class java_03192_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files found in the directory");
            }
        } else {
            System.out.println("The provided path does not exist or is not a directory");
        }

        scanner.close();
    }
}