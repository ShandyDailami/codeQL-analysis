import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29479_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory or path");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files found in the directory");
            return;
        }

        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        for (File file : files) {
            if (file.getName().equals(fileName)) {
                try {
                    if (file.canRead()) {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                        fileScanner.close();
                    } else {
                        System.out.println("You do not have permission to read this file");
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                }
                break;
            }
        }

        scanner.close();
    }
}