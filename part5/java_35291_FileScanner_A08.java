import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35291_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner fileScanner = new Scanner(System.in);
        System.out.println("Enter the path to the file:");
        String filePath = fileScanner.nextLine();
        File file = new File(filePath);

        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File not found: " + filePath);
        }

        fileScanner.close();
    }
}