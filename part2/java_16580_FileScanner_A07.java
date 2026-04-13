import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16580_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("path/to/your/file.txt")); // replace with your file path
            int count = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                count += countOccurrences(line, "AuthFailure");
            }

            scanner.close();

            System.out.println("Count: " + count);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static int countOccurrences(String line, String target) {
        int count = 0;
        int index = 0;

        while ((index = line.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
        }

        return count;
    }
}