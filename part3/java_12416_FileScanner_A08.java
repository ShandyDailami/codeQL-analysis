import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_12416_FileScanner_A08 {
    public static void main(String[] args) {
        String fileName = "myFile.txt"; // name of the file to read
        File file = new File(fileName);

        // File not found exception
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        // Scanner for reading file contents
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        // Print out the contents of the file
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}