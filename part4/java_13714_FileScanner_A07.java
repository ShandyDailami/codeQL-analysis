import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13714_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }
}