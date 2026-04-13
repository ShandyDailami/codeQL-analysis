import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35983_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String fileName = "AuthFailure.txt";

        File file = new File(directory, fileName);

        if (!file.exists()) {
            System.out.println("File " + fileName + " not found!");
            return;
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}