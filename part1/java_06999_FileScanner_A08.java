import java.io.File;
import java.util.Scanner;

public class java_06999_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                if (line.contains("security")) {
                                    System.out.println("Warning: The file contains the word 'security'");
                                } else {
                                    System.out.println("No words 'security' found in the file");
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }
}