import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22443_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            checkAuthFailure();
            System.out.println("AuthFailure file found!");
        } catch (FileNotFoundException e) {
            System.out.println("AuthFailure file not found!");
        }
    }

    public static void checkAuthFailure() throws FileNotFoundException {
        File file = new File("A07_AuthFailure.txt");
        if (file.exists()) {
            throw new FileNotFoundException("AuthFailure file already exists!");
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Found line: " + line);
        }
        scanner.close();
    }
}