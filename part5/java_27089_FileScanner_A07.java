import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_27089_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            // Create a scanner for the file
            Scanner scanner = new Scanner(new File("yourfile.txt"));

            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // If the line contains the string "AuthFailure", print a message
                if (line.contains("AuthFailure")) {
                    System.out.println("Detected AuthFailure in line: " + line);
                }
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}