import java.io.File;
import java.util.Scanner;

public class java_40481_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter file extension: ");
        String fileExtension = scanner.nextLine();

        scanFiles(new File(dirPath), fileExtension);
    }

    public static void scanFiles(File directory, String fileExtension) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(fileExtension)) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    scanFiles(file, fileExtension);
                }
            }
        }
    }
}