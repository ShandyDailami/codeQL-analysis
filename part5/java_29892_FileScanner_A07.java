import java.io.File;
import java.util.Scanner;

public class java_29892_FileScanner_A07 {

    public static void main(String[] args) {
        String directory = new File(".").getAbsolutePath();
        File file = new File(directory + "/authfailure.log");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println("Line: " + line);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}