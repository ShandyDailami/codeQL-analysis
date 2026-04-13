import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10542_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File("path_to_your_directory");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name to search:");
        String fileName = scanner.next();

        try {
            File file = new File(directory, fileName);

            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);

                System.out.println("File content:");
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            } else {
                System.out.println("File not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } finally {
            scanner.close();
        }
    }
}