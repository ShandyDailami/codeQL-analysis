import java.io.File;
import java.util.Scanner;

public class java_13115_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (!directory.exists()) {
            System.out.println("The directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("The input is not a directory.");
            return;
        }

        FileScanner fileScanner = new FileScanner(directory);

        System.out.println("Enter a filter (for example, '.txt'):");
        String filter = scanner.nextLine();

        System.out.println("Enter a file name (for example, 'myFile.txt'):");
        String fileName = scanner.nextLine();

        fileScanner.setFilter(filter);
        fileScanner.setNameFilter(fileName);

        System.out.println("Files that match the filter and name:");
        for (File file : fileScanner.matchFiles()) {
            System.out.println(file.getAbsolutePath());
        }

        scanner.close();
    }
}