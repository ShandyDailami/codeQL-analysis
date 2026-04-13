import java.io.File;
import java.util.Scanner;

public class java_08198_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the file extension (without the dot):");
        String fileExtension = scanner.next();

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        for (File file : txtFiles) {
            System.out.println(file.getAbsolutePath());
        }

        scanner.close();
    }
}