import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29171_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            fileScanner(directory, ".txt");
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }

    private static void fileScanner(File directory, String extension) {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                } else {
                    System.out.println("Found directory: " + file.getAbsolutePath());
                    fileScanner(file, extension);
                }
            }
        }
    }
}