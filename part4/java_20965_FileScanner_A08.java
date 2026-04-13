import java.io.File;
import java.util.Scanner;
import java.util.FileNotFoundException;

public class java_20965_FileScanner_A08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println(txtFile.getName());
                }
            } else {
                System.out.println("No .txt files found in directory!");
            }
        } else {
            System.out.println("Invalid or non-existing directory!");
        }

        scanner.close();
    }
}