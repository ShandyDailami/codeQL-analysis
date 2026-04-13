import java.io.File;
import java.util.Scanner;

public class java_32719_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter the file pattern: ");
        String filePattern = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles((dir2, name) -> name.endsWith(filePattern));

        if (files == null) {
            System.out.println("No files found that match the pattern!");
            return;
        }

        for (File file : files) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
            }
        }
    }
}