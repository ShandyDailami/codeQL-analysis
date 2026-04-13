import java.io.File;
import java.util.Scanner;

public class java_02819_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        System.out.println("File: " + file.getName());

                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println("Line: " + line);

                                // This is a security-sensitive operation related to injection.
                                // We'll remove the line using StringBuilder for simplicity.
                                StringBuilder sb = new StringBuilder(line);
                                sb.replace(0, sb.length(), "");

                                System.out.println("Line after injection attack: " + sb.toString());
                            }
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }
}