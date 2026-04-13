import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37493_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/access_control_file"));
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Some operation here to check if the file contains a line containing 'BROKEN_ACCESS_CONTROL'
                if(line.contains("BROKEN_ACCESS_CONTROL")) {
                    System.out.println("Access control violation detected in: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}