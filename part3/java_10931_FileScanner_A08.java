import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10931_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.isDirectory()) {
            File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    System.out.println("Found text file: " + file.getName());
                }
            } else {
                System.out.println("No text files found.");
            }
        } else {
            System.out.println("Given path is not a directory.");
        }
    }
}