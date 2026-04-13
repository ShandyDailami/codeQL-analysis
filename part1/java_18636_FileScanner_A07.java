import java.io.File;
import java.util.Scanner;

public class java_18636_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    System.out.println("Error: File contains 'A07_AuthFailure'");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}