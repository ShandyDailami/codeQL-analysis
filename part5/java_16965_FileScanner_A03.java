import java.io.File;
import java.util.Scanner;

public class java_16965_FileScanner_A03 {

    private static final String DIRECTORY_PATH = "path_to_your_directory"; // replace with your directory path

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printFilesInDirectory(file);
                }
            }
        }
    }
}