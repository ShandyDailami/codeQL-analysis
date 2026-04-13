import java.io.File;
import java.util.Scanner;

public class java_29039_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileSummary = "This is a file: " + file.getName() + ".\nIts size is: " + file.length() + " bytes.\n";
                        System.out.println(fileSummary);
                    } else if (file.isDirectory()) {
                        System.out.println("This is a directory: " + file.getName() + ".\n");
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}