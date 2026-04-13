import java.io.File;
import java.util.Scanner;

public class java_14929_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        System.out.println("Absolute path: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                        System.out.println("Absolute path: " + file.getAbsolutePath());

                        File[] subFiles = file.listFiles();

                        if (subFiles != null) {
                            for (File subFile : subFiles) {
                                if (subFile.isFile()) {
                                    System.out.println("Sub-file: " + subFile.getName());
                                    System.out.println("Absolute path: " + subFile.getAbsolutePath());
                                } else if (subFile.isDirectory()) {
                                    System.out.println("Sub-directory: " + subFile.getName());
                                    System.out.println("Absolute path: " + subFile.getAbsolutePath());
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}