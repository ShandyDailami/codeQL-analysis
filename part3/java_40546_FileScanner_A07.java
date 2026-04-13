import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40546_FileScanner_A07 {
    private static File file;

    public static void main(String[] args) {
        try {
            file = new File("src/main/resources/authFailure.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (isValid(line)) {
                    System.out.println("User: " + line + " has failed authentication");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValid(String line) {
        // Implement authentication logic here
        // For now, let's assume every line is a valid user name
        return true;
    }
}