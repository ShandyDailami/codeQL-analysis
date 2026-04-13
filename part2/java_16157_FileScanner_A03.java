import java.io.File;
import java.util.Scanner;

public class java_16157_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getPath());
            }
        } else {
            System.out.println("No .txt files found in the specified directory.");
        }
    }
}