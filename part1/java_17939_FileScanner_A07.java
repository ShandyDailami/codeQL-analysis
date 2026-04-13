import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17939_FileScanner_A07 {
    public static void main(String[] args) {
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        password = scanner.next();

        File file = new File("auth.txt");
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.equals(password)) {
                    System.out.println("Access granted!");
                    return;
                }
            }
            System.out.println("Access denied!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}