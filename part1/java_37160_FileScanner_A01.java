import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37160_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        try {
            FileScanner fileScanner = new FileScanner(new File(dirPath));

            System.out.println("Enter the file name to search for:");
            String fileName = scanner.nextLine();

            fileScanner.searchForFile(fileName);

            System.out.println("Enter the file extension to search for (leave blank for all extensions):");
            String extension = scanner.nextLine();

            fileScanner.searchForFile(fileName, extension);

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}