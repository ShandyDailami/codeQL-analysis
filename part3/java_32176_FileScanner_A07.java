import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32176_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/AuthFailureData.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            // Your security-sensitive operation here, e.g., checking for authentication failure
            // ...
            // Your security-sensitive operation here, e.g., logging the event
            // ...
        }

        scanner.close();
    }
}