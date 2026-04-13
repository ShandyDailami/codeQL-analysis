import java.io.File;
import java.util.Scanner;

public class java_35887_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // File is a text file, not a directory
                        if (file.getName().endsWith(".txt")) {
                            System.out.println("Processing file: " + file.getName());
                            fileProcess(file);
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Processing directory: " + file.getName());
                        fileProcess(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }

        scanner.close();
    }

    private static void fileProcess(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Do some security sensitive operation here using line
                // For example, use a SQL injection attack here
                // (Note: not recommended due to potential SQL injection vulnerability)
                System.out.println("Processed line: " + line);
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error processing file: " + file.getName());
            e.printStackTrace();
        }
    }
}