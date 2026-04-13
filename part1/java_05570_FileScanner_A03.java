import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_05570_FileScanner_A03 {
    private static final String DIRECTORY = "./testDirectory/"; // replace with your directory

    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File(DIRECTORY);
        File[] listOfFiles = dir.listFiles();
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // No injection, only the file name contains user input,
                    // use of println or similar for real-world use cases is recommended.
                    System.out.println("Found line: " + line);
                }
                scanner.close();
            }
        }
    }
}