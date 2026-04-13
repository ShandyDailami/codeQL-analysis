import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03117_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/sampleFile.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Here we can add code to securely handle the line
            // For example, we can use a simple check to see if the line contains a certain pattern
            if (line.contains("securePattern")) {
                // If the line contains the secure pattern, we can print the line to the console
                System.out.println("Detected secure line: " + line);
            }
        }
        scanner.close();
    }
}