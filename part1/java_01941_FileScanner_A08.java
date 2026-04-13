import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01941_FileScanner_A08 {

    public static void main(String[] args) {
        String fileName = "A08_IntegrityFailure";
        File file = new File(fileName);

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
            }
        } else {
            System.out.println("File not found: " + fileName);
        }
    }
}