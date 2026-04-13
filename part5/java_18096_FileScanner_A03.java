import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18096_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a File object for the credentials file
        File credentialsFile = new File("credentials.txt");

        // Create a Scanner object to read the file
        try (Scanner scanner = new Scanner(credentialsFile)) {
            // Read and print each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Credentials file not found!");
        }
    }
}