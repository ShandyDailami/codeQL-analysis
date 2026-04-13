import java.io.File;
import java.util.Scanner;

public class java_29020_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the extension of the files you want to scan: ");
        String extension = scanner.nextLine();

        String directoryPath = "."; // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File size: " + file.length() + " bytes");
                        System.out.println("------------------------------");
                    }
                }
            } else {
                System.out.println("No files found with the specified extension.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

        scanner.close();
    }
}