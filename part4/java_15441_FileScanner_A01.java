import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_15441_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        System.out.println("Reading files in directory: " + directoryPath);

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile() && file.canRead()) {
                System.out.println("\nContent of file: " + file.getName());
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            }
        }

        scanner.close();
    }
}