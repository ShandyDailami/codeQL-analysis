import java.io.File;
import java.util.Scanner;

public class java_23589_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the directory:");
        String path = scanner.next();
        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        printDirectoryContents(file);
                    } else {
                        printFileContents(file);
                    }
                }
            } else {
                System.out.println("Invalid directory");
            }
        } else {
            System.out.println("Invalid path");
        }

        scanner.close();
    }

    private static void printDirectoryContents(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printDirectoryContents(file);
                } else {
                    printFileContents(file);
                }
            }
        }
    }

    private static void printFileContents(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}