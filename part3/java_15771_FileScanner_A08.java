import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_15771_FileScanner_A08 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileScanner <file name>");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            System.exit(2);
        }

        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
            System.out.println("Number of lines: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}