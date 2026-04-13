import java.io.File;
import java.util.Scanner;

public class java_32863_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            findFilesInDirectory(directory, false);
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private static void findFilesInDirectory(File directory, boolean printPath) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.isHidden()) {
                    if (printPath) {
                        System.out.println(file.getAbsolutePath());
                    } else {
                        System.out.println(file.getName());
                    }
                } else if (file.isDirectory()) {
                    findFilesInDirectory(file, printPath);
                }
            }
        }
    }
}