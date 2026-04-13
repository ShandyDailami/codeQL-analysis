import java.io.File;
import java.util.Scanner;

public class java_17590_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println("Found text file: " + file.getName());
            }
        } else {
            System.out.println("No text files found in directory.");
        }
    }
}