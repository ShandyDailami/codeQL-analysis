import java.io.File;
import java.util.Scanner;

public class java_13595_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file type (for example, .txt):");
        String fileType = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileType));

        if (files == null) {
            System.out.println("No files found in the directory!");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        }
    }
}