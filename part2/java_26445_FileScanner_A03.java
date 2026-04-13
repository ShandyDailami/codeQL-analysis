import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26445_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/input.txt"));

            // We're assuming the file contains a sequence of integers separated by newline characters.
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");

                if (parts.length == 2) {
                    int a = Integer.parseInt(parts[0]);
                    int b = Integer.parseInt(parts[1]);

                    // This is a security-sensitive operation related to A03_Injection.
                    // We're not doing anything with the input here.

                    // This is just a creative way to demonstrate FileScanner.
                    System.out.println("Processing (" + a + ", " + b + ")");
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + e.getMessage());
        }
    }
}