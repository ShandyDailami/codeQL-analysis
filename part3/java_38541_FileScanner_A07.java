import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38541_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".");

        // Use a Scanner to read the file content
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String filename = scanner.nextLine();
                System.out.println("File: " + filename);

                // Use another scanner to read the file content
                try (Scanner contentScanner = new Scanner(file)) {
                    while (contentScanner.hasNext()) {
                        String content = contentScanner.nextLine();
                        System.out.println(content);
                    }
                }
            }
        }
    }
}