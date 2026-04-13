import java.io.File;
import java.util.Scanner;

public class java_03399_FileScanner_A03 {
    public static void main(String[] args) {
        // Ask the user for a directory
        System.out.println("Enter a directory:");
        Scanner scanner = new Scanner(System.in);
        String directory = scanner.nextLine();
        scanner.close();

        // Get all .txt files in the directory
        File dir = new File(directory);
        File[] txtFiles = dir.listFiles((dir2, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files found.");
        }
    }
}