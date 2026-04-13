import java.io.File;
import java.util.Scanner;

public class java_15702_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("Found security-sensitive operation related to integrity failure in file: " + file.getPath());
                    }
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred while trying to access the directory or files.");
        }
    }
}