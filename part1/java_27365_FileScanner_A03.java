import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27365_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File("/tmp/test");
        File file = new File(directory, "A03_Injection");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + file.getPath() + " was not found");
        }
    }
}