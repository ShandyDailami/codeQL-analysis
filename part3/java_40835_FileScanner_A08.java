import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_40835_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files)
                        .filter(file -> file.getName().endsWith(".txt"))
                        .forEach(file -> {
                            try {
                                FileScanner fileScanner = new FileScanner(file);
                                fileScanner.start();
                            } catch (Exception e) {
                                System.out.println("An error occurred while processing the file: " + file.getName());
                            }
                        });
            } else {
                System.out.println("No text files found in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

        scanner.close();
    }
}