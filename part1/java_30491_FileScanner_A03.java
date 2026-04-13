import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30491_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The specified directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("The specified path is not a directory.");
            return;
        }

        FileScanner fileScanner = new FileScanner(directory);

        System.out.println("\nFiles in the directory:");

        while (fileScanner.hasNext()) {
            File file = fileScanner.nextFile();
            System.out.println(file.getName());
        }

        fileScanner.close();
    }
}