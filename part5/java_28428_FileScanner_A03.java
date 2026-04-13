import java.io.File;
import java.util.Scanner;

public class java_28428_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        handleFile(file);
                    } else if (file.isDirectory()) {
                        handleDirectory(file);
                    }
                }
            } else {
                System.out.println("Directory not found.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }

    private static void handleFile(File file) {
        try {
            String fileContent = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            System.out.println("Content of file: " + fileContent);

            // Example of a potential injection point
            String injectionString = "Injection point";
            System.out.println("Content after injection: " + fileContent.contains(injectionString));

        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }

    private static void handleDirectory(File directory) {
        try {
            String[] fileNames = directory.list();
            for (String fileName : fileNames) {
                File file = new File(directory.getPath() + "/" + fileName);

                if (file.isFile()) {
                    handleFile(file);
                } else if (file.isDirectory()) {
                    handleDirectory(file);
                }
            }
        } catch (Exception e) {
            System.out.println("Error listing files in directory: " + directory.getPath());
        }
    }
}