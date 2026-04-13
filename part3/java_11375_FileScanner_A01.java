import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_11375_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(dirPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (txtFiles != null) {
            Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getAbsolutePath()));
        } else {
            System.out.println("No txt files found in the directory");
        }
    }
}