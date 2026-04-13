import java.io.File;
import java.util.Scanner;

public class java_41543_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            fileScanner(directory);
        } else {
            System.out.println("The provided path is not a valid directory.");
        }

        scanner.close();
    }

    private static void fileScanner(File directory) {
        if (directory.listFiles() != null) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    try {
                        if (file.canRead()) {
                            System.out.println("File name: " + file.getName());
                            System.out.println("Absolute path: " + file.getAbsolutePath());
                            System.out.println("Readable: " + file.canRead());
                            System.out.println("Writable: " + file.canWrite());
                            System.out.println("Executable: " + file.canExecute());
                            System.out.println("-------------------------------");
                        } else {
                            System.out.println("File name: " + file.getName());
                            System.out.println("Absolute path: " + file.getAbsolutePath());
                            System.out.println("Readable: " + file.canRead());
                            System.out.println("Writable: " + file.canWrite());
                            System.out.println("Executable: " + file.canExecute());
                            System.out.println("-------------------------------");
                            System.out.println("File is not readable. Skipping...");
                        }
                    } catch (Exception e) {
                        System.out.println("An error occurred while processing the file: " + file.getName());
                        System.out.println("Error message: " + e.getMessage());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory name: " + file.getName());
                    System.out.println("Absolute path: " + file.getAbsolutePath());
                    fileScanner(file);
                }
            }
        }
    }
}