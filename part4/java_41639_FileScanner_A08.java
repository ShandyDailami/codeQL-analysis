import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_41639_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Enter the file name to search:");
            String fileName = scanner.nextLine();

            File file = new File(directory, fileName);

            try {
                if (file.exists() && file.canRead()) {
                    Scanner fileScanner = new Scanner(file);

                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }

                    fileScanner.close();
                } else {
                    System.out.println("File not found or not readable");
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("Directory does not exist or is not a directory");
        }

        scanner.close();
    }
}