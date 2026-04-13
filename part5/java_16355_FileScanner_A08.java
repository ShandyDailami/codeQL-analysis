import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_16355_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Enter file extension:");
            String fileExtension = scanner.nextLine();

            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (txtFiles != null) {
                Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getName()));
            } else {
                System.out.println("No .txt files found in the directory!");
            }
        } else {
            System.out.println("Invalid directory!");
        }
    }
}