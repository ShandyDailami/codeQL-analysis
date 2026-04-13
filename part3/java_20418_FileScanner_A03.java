import java.io.File;
import java.util.Scanner;

public class java_20418_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.next();

        File file = new File(directoryPath);
        File[] txtFiles = file.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println("Found .txt file: " + txtFile.getPath());
            }
        } else {
            System.out.println("No .txt files found in the directory.");
        }
    }
}