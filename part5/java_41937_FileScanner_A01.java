import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41937_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/security-sensitive-data.txt");
        Scanner fileScanner = null;

        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            e.printStackTrace();
            System.exit(1);
        }

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // Perform security-sensitive operations related to A01_BrokenAccessControl
            System.out.println("Line read from file: " + line);
        }

        fileScanner.close();
    }
}