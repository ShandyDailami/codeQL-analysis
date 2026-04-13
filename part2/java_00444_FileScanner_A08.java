import java.io.File;
import java.util.Scanner;

public class java_00444_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt")) {
                            System.out.println("Checking for potential security intrusion in file: " + fileName);
                            file.setReadable(false, false);
                            file.setWritable(false, false);
                            file.setExecutable(false, false);
                            System.out.println("Successfully changed permissions for " + fileName);
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Checking for potential security intrusion in directory: " + file.getPath());
                        File[] innerFiles = file.listFiles();
                        if (innerFiles != null) {
                            for (File innerFile : innerFiles) {
                                if (innerFile.isFile()) {
                                    String innerFileName = innerFile.getName();
                                    if (innerFileName.endsWith(".txt")) {
                                        System.out.println("Successfully changed permissions for " + innerFileName);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("No files or directories found in the specified directory.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}