import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_25221_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file path:");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);

        if (file.exists()) {
            try {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        } else {
            System.out.println("File does not exist!");
        }
    }
}