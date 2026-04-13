import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class java_31723_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            scanFilesInDirectory(directory);
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }

    private static void scanFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (!file.getName().endsWith(".class") && !Objects.equals(file.getName(), ".") && !Objects.equals(file.getName(), "..")) {
                        scanFile(file);
                    }
                } else if (file.isDirectory()) {
                    scanFilesInDirectory(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        if (file.getName().endsWith(".java")) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            } catch (Exception e) {
                System.out.println("Failed to scan file: " + file.getName());
            }
        }
    }
}