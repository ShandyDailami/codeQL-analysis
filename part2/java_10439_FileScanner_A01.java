import java.io.File;
import java.util.Scanner;

public class java_10439_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        try {
            File file = new File(filePath);
            if (file.exists()) {
                readFile(file);
            } else {
                System.out.println("File not found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        scanner.close();
    }

    private static void readFile(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}