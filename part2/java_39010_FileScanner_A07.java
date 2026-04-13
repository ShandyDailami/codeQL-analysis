import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.FileReader;
import java.io.IOException;

public class java_39010_FileScanner_A07 {
    public static void main(String[] args) {
        String fileName = "path_to_file";
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(new FileReader(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Sensitive operation: Printing line to verify file content.
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
        }
    }
}