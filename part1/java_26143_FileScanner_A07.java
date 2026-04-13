import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class java_26143_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get current directory
        File file = new File(".");

        // Get the system's properties
        System.out.println("Current directory: " + file.getAbsolutePath());

        // Use InputStream to read the directory
        InputStream inputStream = file.list()
                .getClass()
                .getClassLoader()
                .getResourceAsStream("/");

        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}