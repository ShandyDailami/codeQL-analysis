import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40465_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Please provide a file name as the argument.");
            System.exit(1);
        }

        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("password") || line.contains("login") || line.contains("access")) {
                System.out.println("Sensitive information detected: " + line);
            }
        }

        scanner.close();
    }
}