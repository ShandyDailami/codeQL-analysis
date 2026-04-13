import java.io.File;
import java.util.Scanner;

public class java_20361_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            String[] txtFiles = directory.list((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (String txtFile : txtFiles) {
                    System.out.println("Found .txt file: " + txtFile);
                }
            } else {
                System.out.println("No .txt files found in the directory");
            }
        } else {
            System.out.println("Invalid or non-existent directory");
        }
    }
}