import java.io.File;
import java.util.Scanner;

public class java_34705_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the extension of the files you want to scan:");
        String extension = scanner.next();

        String dirPath = "C:\\Users\\User\\Documents"; // replace with your directory path
        File directory = new File(dirPath);

        findFilesWithExtension(directory, extension);
    }

    public static void findFilesWithExtension(File directory, String extension) {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    findFilesWithExtension(file, extension);
                }
            }
        }
    }
}