import java.io.File;
import java.util.Scanner;

public class java_35656_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            File[] txtFiles = dir.listFiles((File dir, String name) -> name.endsWith(".txt"));
            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println("Found .txt file: " + txtFile.getAbsolutePath());
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }

        scanner.close();
    }
}