import java.io.File;
import java.util.Scanner;

public class java_23608_FileScanner_A08 {
    public static void main(String[] args) {
        String userHome = System.getProperty("user.home");
        File file = new File(userHome, "test.txt");

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            }
        } else {
            System.out.println("File not found!");
        }
    }
}