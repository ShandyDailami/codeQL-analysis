import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40995_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for file in directory: " + directoryPath);
            File file = new File(directory, "A07_AuthFailure.txt");

            try {
                if (file.createNewFile()) {
                    System.out.println("File created successfully");
                } else {
                    System.out.println("File already exists");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file: " + e.getMessage());
            }
        } else {
            System.out.println("The provided path does not exist or is not a directory");
        }

        scanner.close();
    }
}