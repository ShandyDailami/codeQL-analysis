import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37151_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the file you want to scan:");
        String fileName = scanner.next();

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("Enter the pattern you want to search for:");
            String pattern = scanner.next();

            int lineNumber = 0;
            while (fileScanner.hasNextLine()) {
                lineNumber++;
                String line = fileScanner.nextLine();
                if (line.contains(pattern)) {
                    System.out.println(lineNumber + ": " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}