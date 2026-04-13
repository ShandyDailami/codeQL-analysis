import java.io.File;
import java.util.Scanner;

public class java_15775_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    System.out.println("Found .txt file: " + file.getName());
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }
}