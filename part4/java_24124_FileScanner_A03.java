import java.io.File;
import java.util.Scanner;

public class java_24124_FileScanner_A03 {

    static void scanDirectory(File directory, String extension) {
        File[] list = directory.listFiles();

        if (list != null) {
            for (File file : list) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    System.out.println("File Found: " + file.getPath());
                } else if (file.isDirectory()) {
                    scanDirectory(file, extension);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();
        System.out.println("Enter the file extension:");
        String extension = scanner.next();

        File directory = new File(path);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                scanDirectory(directory, extension);
            } else {
                System.out.println("Invalid directory path");
            }
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }
}