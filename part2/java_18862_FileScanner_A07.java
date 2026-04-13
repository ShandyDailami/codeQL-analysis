import java.io.File;
import java.util.Scanner;

public class java_18862_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            fileSearch(directory, ".txt");
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }

        scanner.close();
    }

    private static void fileSearch(File directory, String extension) {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    fileSearch(file, extension);
                }
            }
        }
    }
}