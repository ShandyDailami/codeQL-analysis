import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07611_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Enter file extension:");
            String extension = scanner.nextLine();
            findFiles(directory, extension);
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }

        scanner.close();
    }

    private static void findFiles(File directory, String extension) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    System.out.println("Found file: " + file.getPath());
                } else if (file.isDirectory()) {
                    findFiles(file, extension);
                }
            }
        }
    }
}