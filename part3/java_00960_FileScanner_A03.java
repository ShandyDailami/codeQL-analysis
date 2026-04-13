import java.io.File;
import java.util.Scanner;

public class java_00960_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        File[] txtFiles = dir.listFiles((dir2, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            System.out.println("Number of .txt files in " + dirPath + ": " + txtFiles.length);
        } else {
            System.out.println("No .txt files found in " + dirPath);
        }

        scanner.close();
    }
}