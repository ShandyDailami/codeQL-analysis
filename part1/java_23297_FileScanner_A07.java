import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23297_FileScanner_A07 {
    private static final String FILE_PATH = "src/main/resources/authFailure.txt"; // Specify your own file path

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                if (file.canRead()) {
                    if (isPasswordCorrect(file, password)) {
                        System.out.println("Access granted!");
                    } else {
                        System.out.println("Access denied! Your password is incorrect.");
                    }
                } else {
                    System.out.println("Access denied! Your file is not readable.");
                }
            } else {
                System.out.println("Access denied! The file you are trying to access does not exist.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Access denied! File not found.");
        }

        scanner.close();
    }

    private static boolean isPasswordCorrect(File file, String password) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}