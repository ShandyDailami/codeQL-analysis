import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_00056_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("sample.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int sum = 0;
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sum += Character.getNumericValue(c);
                    }
                }
                System.out.println("Sum of digits in line: " + sum);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}