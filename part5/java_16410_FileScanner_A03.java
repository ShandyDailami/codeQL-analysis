import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16410_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        if (file.isDirectory()) {
            System.out.println("Provided path is a directory, not a file");
            return;
        }

        if (file.canRead()) {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // TODO: Use a secure method to prevent Injection attacks. 
                // For example, use parameterized queries or stored procedures instead of concatenating strings.
                System.out.println("Found line: " + line);
            }
            fileScanner.close();
        } else {
            System.out.println("File is not readable");
        }
    }
}