import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_41310_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();

            if (files != null) {
                Arrays.stream(files)
                      .filter(file -> file.endsWith(".java"))
                      .forEach(Main::printFile);
            } else {
                System.out.println("No files in the directory");
            }
        } else {
            System.out.println("Invalid directory or it does not exist");
        }

        scanner.close();
    }

    private static void printFile(String file) {
        System.out.println("File: " + file);
    }
}