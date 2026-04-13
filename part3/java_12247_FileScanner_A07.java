import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12247_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/A07_AuthFailure.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).{8,}$")) {
                    System.out.println("Security-Sensitive Operation: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}