import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_29439_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            System.exit(1);
        }

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (txtFiles == null) {
            System.out.println("No .txt files found in the directory");
            System.exit(1);
        }

        System.out.println("Found .txt files in the directory: " + directory.getPath());
        Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getName()));
    }
}