import java.io.File;
import java.util.Scanner;

public class java_13552_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        scanner.close();

        try {
            File file = new File(filePath);
            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            } else {
                System.out.println("File not found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}