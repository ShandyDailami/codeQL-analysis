import java.io.File;
import java.util.Scanner;

public class java_27917_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt"); // replace with your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
           
                // Add security-sensitive operations here
                // For example, to check if a line contains a specific password,
                // you can use something like:
                // if (line.contains("password")) {
                //     System.out.println("Password found!");
                // }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}