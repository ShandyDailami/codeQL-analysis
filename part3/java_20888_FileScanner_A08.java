import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_20888_FileScanner_A08 {
    public static void main(String[] args) {
        String fileName = "src/main/java/FileScannerExample.java"; // replace with your file path
        String word = "A08_IntegrityFailure";

        try {
            Scanner scanner = new Scanner(new File(fileName));
            int count = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(word)) {
                    count++;
                }
            }

            System.out.println("The word '" + word + "' was found " + count + " times in the file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}