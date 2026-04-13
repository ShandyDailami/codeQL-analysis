import java.io.File;
import java.util.Scanner;

public class java_11999_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println("Found .txt file: " + txtFile.getName());
            }
        } else {
            System.out.println("No .txt files found in " + directoryPath);
        }
    }
}