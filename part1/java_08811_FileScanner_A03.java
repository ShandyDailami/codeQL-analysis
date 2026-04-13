import java.io.File;
import java.util.Scanner;

public class java_08811_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("File found!");

                // Example of a security-sensitive operation related to injection
                // Let's assume we are reading the contents of the file and printing it
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                } catch (Exception e) {
                    System.out.println("An error occurred while reading the file. " + e.getMessage());
                }
            } else {
                System.out.println("Path does not point to a file.");
            }
        } else {
            System.out.println("File does not exist.");
        }

        scanner.close();
    }
}