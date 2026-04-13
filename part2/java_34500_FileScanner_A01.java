import java.io.File;
import java.util.Scanner;

public class java_34500_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String path = scanner.next();

        File directory = new File(path);
        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println("File: " + file.getName());

                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println("Line: " + line);

                        // Remove access to file due to security issue
                    }
                    fileScanner.close();
                } catch (Exception e) {
                    System.out.println("Error reading file: " + file.getName());
                }
            }
        }
    }
}