import java.io.File;
import java.util.Scanner;

public class java_03100_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println("File: " + txtFile.getName() + ", Path: " + txtFile.getPath());
            }
        } else {
            System.out.println("No .txt files found in the directory");
        }

        scanner.close();
    }
}