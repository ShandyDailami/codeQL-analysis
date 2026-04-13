import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09011_FileScanner_A08 {
    private static File file;
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Enter file path:");
        Scanner input = new Scanner(System.in);
        String filePath = input.nextLine();

        try {
            file = new File(filePath);
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}