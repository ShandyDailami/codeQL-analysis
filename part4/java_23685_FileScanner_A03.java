import java.io.File;
import java.util.Scanner;

public class java_23685_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFilesInDirectory(directory);
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }

    private static void listFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    listFilesInDirectory(file);
                }
            }
        }
    }
}