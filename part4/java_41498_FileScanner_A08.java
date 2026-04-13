import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_41498_FileScanner_A08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getAbsolutePath()));
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

        scanner.close();
    }
}