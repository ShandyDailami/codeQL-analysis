import java.io.File;
import java.util.Scanner;

public class java_28453_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();

            if (files != null) {
                for (String file : files) {
                    File currentFile = new File(directoryPath, file);

                    if (currentFile.isFile() && currentFile.canRead()) {
                        System.out.println(file);
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }

        scanner.close();
    }
}