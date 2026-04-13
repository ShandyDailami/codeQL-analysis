import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23534_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the file: ");
        String filePath = scanner.nextLine();
        File file = new File(filePath);

        if (file.exists()) {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // This is a security-sensitive operation, but it's not mentioned in the question.
                // You should replace this with a real operation related to authentication failure.
                // For instance, checking if a line contains a failed login attempt.
                if (line.contains("FAILURE")) {
                    System.out.println("Authentication failure detected in line: " + line);
                }
            }
            fileScanner.close();
        } else {
            System.out.println("File not found");
        }
    }
}