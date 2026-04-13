import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22886_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory");
            return;
        }

        try {
            FileScanner fileScanner = new FileScanner(directory);

            System.out.println("Enter a filename to search:");
            String filename = scanner.nextLine();

            File file = new File(directory, filename);

            if (!file.exists()) {
                System.out.println("File does not exist");
                return;
            }

            System.out.println("File found: " + file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}