import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26340_FileScanner_A01 {
    private static final String SECURITY_THRESHOLD = "A01_BrokenAccessControl";

    public static void main(String[] args) {
        File file = new File("access_control_file.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(SECURITY_THRESHOLD)) {
                    System.out.println("Security threshold violated in file: " + file.getName());
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
            e.printStackTrace();
        }
    }
}