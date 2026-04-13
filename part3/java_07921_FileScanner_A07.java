import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07921_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("auth.log"); // Replace with your log file path
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("Failed password") || line.contains("Failed to authenticate user")) {
                System.out.println("Authentication failure detected in " + file.getPath());
                break;
            }
        }

        scanner.close();
    }
}