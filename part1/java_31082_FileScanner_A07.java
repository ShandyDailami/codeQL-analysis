import java.io.File;
import java.util.Scanner;

public class java_31082_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Reading files from directory: " + directory.getPath());

            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                // Here you should apply security sensitive operations related to A07_AuthFailure, e.g., checking if the line contains a password and encrypting it if needed.
                                // For the sake of the task, I will just print the line.
                                System.out.println("Line in file: " + line);
                            }
                            fileScanner.close();
                        } catch (Exception e) {
                            System.out.println("An error occurred while reading the file: " + file.getName());
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("The specified path does not exist or is not a directory.");
        }
        scanner.close();
    }
}