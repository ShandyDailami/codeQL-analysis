import java.io.File;
import java.util.Scanner;

public class java_28952_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            FileScanner fileScanner = new FileScanner(directory);

            System.out.println("\nFiles in directory " + directory.getPath() + ":");
            fileScanner.scan();

            fileScanner.close();
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}