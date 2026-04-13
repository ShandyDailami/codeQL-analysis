import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_31212_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file path: ");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        if (file.isFile()) {
            System.out.println("Not a directory!");
            return;
        }

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
    }
}