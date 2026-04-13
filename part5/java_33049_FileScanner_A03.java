import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33049_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/textfile.txt"); // replace with your file path
        int count = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                count += countOccurrences(line, "A03_Injection");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        System.out.println("Number of occurrences: " + count);
    }

    private static int countOccurrences(String line, String target) {
        int count = 0;
        int index = line.indexOf(target);

        while (index != -1) {
            count++;
            index = line.indexOf(target, index + target.length());
        }

        return count;
    }
}