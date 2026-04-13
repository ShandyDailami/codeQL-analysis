import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21796_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_file");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("sensitive operation")) {
                    // Perform the security-sensitive operation
                    // ...

                    // If the operation is successful, print a message
                    System.out.println("AuthFailure: Operation succeeded!");
                } else {
                    System.out.println("AuthFailure: Operation failed.");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("AuthFailure: File not found.");
        }
    }
}