import java.io.File;
import java.util.Scanner;

public class java_13858_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFilesInDirectory(directory);
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }

    private static void listFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    listFilesInDirectory(file);
                }
            }
        }
    }
}