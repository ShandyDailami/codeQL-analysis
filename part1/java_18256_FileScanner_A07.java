import java.io.File;
import java.util.Scanner;

public class java_18256_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a new File object
        File file = new File("AuthFailure.txt");

        // Check if the file exists
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                // If the file exists and is readable, print each line of the file
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
}