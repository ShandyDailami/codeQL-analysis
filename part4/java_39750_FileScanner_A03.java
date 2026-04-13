import java.io.File;
import java.util.Scanner;

public class java_39750_FileScanner_A03 {

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
                        if (file.getName().endsWith(".txt")) {
                            System.out.println("File name: " + file.getName());
                            readFile(file);
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                        readDirectory(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }

    private static void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }

    private static void readDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        System.out.println("File name: " + file.getName());
                        readFile(file);
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    readDirectory(file);
                }
            }
        }
    }
}