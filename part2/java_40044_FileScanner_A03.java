import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_40044_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        File directory = new File(dirPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        String[] files = directory.list();

        if (files == null) {
            System.out.println("No files found.");
            return;
        }

        for (String fileName : files) {
            File file = new File(directory.getPath(), fileName);
            if (isFileSafeToDelete(file)) {
                file.delete();
            }
        }

        scanner.close();
    }

    private static boolean isFileSafeToDelete(File file) {
        String filename = file.getName();
        return filename.endsWith(".txt") || filename.endsWith(".log");
    }
}