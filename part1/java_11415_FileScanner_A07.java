import java.io.File;
import java.util.Scanner;

public class java_11415_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File dir = new File(dirPath);

        File[] files = dir.listFiles((dir2, name) -> name.endsWith(fileExtension));

        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}