import java.io.File;
import java.util.Scanner;

public class java_41682_FileScanner_A08 {
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
                        String fileName = file.getName();
                        if (fileName.endsWith(".java")) {
                            try (Scanner fileScanner = new Scanner(file)) {
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    if (line.matches(".*\\b(System.out\\.println|System\\.out\\.println).*")) {
                                        System.out.println("Integrity failure found in file: " + fileName);
                                    }
                                }
                            }
                        }
                    } else if (file.isDirectory()) {
                        checkDirectory(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }

    private static void checkDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".java")) {
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                if (line.matches(".*\\b(System.out\\.println|System\\.out\\.println).*")) {
                                    System.out.println("Integrity failure found in file: " + fileName);
                                }
                            }
                        }
                    }
                } else if (file.isDirectory()) {
                    checkDirectory(file);
                }
            }
        }
    }
}