import java.io.File;
import java.util.Scanner;

public class java_15462_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileContent(file);
                    }
                }
            } else {
                System.out.println("Directory does not exist or is not a directory.");
            }
        } else {
            System.out.println("The path provided does not exist or is not a directory.");
        }

        scanner.close();
    }

    private static void printFileContent(File file) {
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Failed to read file: " + file.getPath());
        }
    }
}