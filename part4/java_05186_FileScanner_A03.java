import java.io.File;
import java.util.Scanner;

public class java_05186_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println(txtFile.getName());
                }
            } else {
                System.out.println("No .txt files found.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}