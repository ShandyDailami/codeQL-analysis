import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00249_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/security.txt");
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("A08_IntegrityFailure")) {
                    System.out.println("Potential integrity failure detected in: " + file.getPath());
                    System.out.println("Line: " + line);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
            e.printStackTrace();
        }
    }
}