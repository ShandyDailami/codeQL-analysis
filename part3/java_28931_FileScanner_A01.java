import java.io.File;
import java.util.Scanner;

public class java_28931_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        for (File file : txtFiles) {
            System.out.println("File found: " + file.getName());
        }
    }
}