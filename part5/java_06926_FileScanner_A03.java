import java.io.File;
import java.util.Scanner;

public class java_06926_FileScanner_A03 {
    private static String directoryPath;
    private static String fileExtension;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        directoryPath = scanner.nextLine();

        System.out.println("Enter file extension:");
        fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with extension: " + fileExtension);
        }
    }
}