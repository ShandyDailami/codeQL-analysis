import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26880_FileScanner_A03 {

    private static final String HOME_DIRECTORY = System.getProperty("user.dir");
    private static final String FILE_NAME = "injection.txt";

    public static void main(String[] args) {
        try {
            scanFileForInjection(new File(HOME_DIRECTORY + "/" + FILE_NAME));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static void scanFileForInjection(File file) throws FileNotFoundException {
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You can use the line here to scan for injection
                // For example, use a regular expression to find common vulnerabilities
                // This is a very minimalist way to demonstrate injection vulnerabilities
                if (line.matches(".*password=.*")) {
                    System.out.println("Detected injection in file: " + file.getPath());
                }
            }
            scanner.close();
        } else {
            throw new FileNotFoundException("File not found: " + file.getPath());
        }
    }
}