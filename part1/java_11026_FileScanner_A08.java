import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_11026_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the file path:");
        String filePath = input.nextLine();

        File file = new File(filePath);

        if (file.exists() && file.canRead(filePath)) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File not found or not readable");
        }

        input.close();
    }

    public static boolean isIntegritySafe(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.canRead(filePath);
    }
}