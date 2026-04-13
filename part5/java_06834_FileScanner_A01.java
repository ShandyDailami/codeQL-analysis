import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06834_FileScanner_A01 {
    private static final String DIR_PATH = "C:\\path\\to\\your\\directory";

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a filename to search for in the directory:");
            String filename = scanner.nextLine();
            File fileToSearch = new File(dir, filename);
            if (fileToSearch.exists()) {
                System.out.println("File found: " + fileToSearch.getPath());
            } else {
                System.out.println("File not found: " + filename);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}