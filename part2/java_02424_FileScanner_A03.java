import java.io.File;
import java.util.Scanner;

public class java_02424_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the extension to search for (e.g., .txt): ");
        String extension = scanner.next();

        File file = new File(".");

        FileScanner(file, extension);
    }

    private static void FileScanner(File file, String extension) {
        File[] foundFiles = file.listFiles((dir, name) -> name.endsWith(extension));

        if (foundFiles == null) {
            System.out.println("No files with extension " + extension + " found.");
        } else {
            for (File f : foundFiles) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}