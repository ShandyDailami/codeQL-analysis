import java.io.File;
import java.util.Scanner;

public class java_03099_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println("Found text file: " + txtFile.getAbsolutePath());
            }
        } else {
            System.out.println("No text files found in the directory.");
        }
    }
}