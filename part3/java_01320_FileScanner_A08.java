import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class java_01320_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path (or 'q' to quit): ");
        String path = scanner.nextLine();

        while (!path.equals("q")) {
            File file = new File(path);

            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }

                fileScanner.close();
            } else {
                System.out.println("File not found at path: " + path);
            }

            System.out.print("Enter file path (or 'q' to quit): ");
            path = scanner.nextLine();
        }

        scanner.close();
    }
}