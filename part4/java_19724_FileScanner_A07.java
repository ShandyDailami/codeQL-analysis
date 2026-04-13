import java.io.File;
import java.util.Scanner;

public class java_19724_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        for (File file : files) {
            System.out.println(file.getPath());
        }
    }
}