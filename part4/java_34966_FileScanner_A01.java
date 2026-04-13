import java.io.File;
import java.util.Scanner;

public class java_34966_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        scanDirectory(new File(directoryPath), fileName);
    }

    private static void scanDirectory(File directory, String fileName) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    if (file.isFile()) {
                        System.out.println("Found file: " + file.getAbsolutePath());
                    } else {
                        System.out.println("Found directory: " + file.getAbsolutePath());
                        scanDirectory(file, fileName);
                    }
                }
            }
        }
    }
}