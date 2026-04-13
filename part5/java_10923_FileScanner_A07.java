import java.io.File;
import java.util.Scanner;

public class java_10923_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        System.out.println("Scanning for .txt files:");

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getPath());
            }
        } else {
            System.out.println("No .txt files found in directory.");
        }

        scanner.close();
    }
}