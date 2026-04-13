import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class java_38670_XMLParser_A03 {
    public static void main(String[] args) {
        // Step 1: Get user input for XML file path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the path to the XML file: ");
        String filePath = scanner.nextLine();

        // Step 2: Open the file and create an InputStreamReader
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            // Step 3: Use the XML API to parse the file
            while (reader.ready()) {
                int data = reader.read();
                System.out.print((char) data);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}