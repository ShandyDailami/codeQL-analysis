import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33043_FileScanner_A03 {

    public static void main(String[] args) {

        // Prompt for file path
        System.out.print("Please enter the file path: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        // Create a File object
        File file = new File(filePath);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // Use FileScanner to read the file
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);

                // This is where the injection attempt occurs
                String injectionAttempt = "whoami\n" + line;
                System.out.println(injectionAttempt);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}