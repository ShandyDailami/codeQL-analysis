import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23871_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file"); // replace with your file path
            Scanner scanner = new Scanner(file);

            String password = "your_password_here"; // replace with your password
            boolean passwordFound = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(password)) {
                    passwordFound = true;
                    break;
                }
            }

            scanner.close();

            if (passwordFound) {
                System.out.println("Password found in file!");
            } else {
                System.out.println("Password not found in file!");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}