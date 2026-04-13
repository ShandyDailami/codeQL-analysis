import java.io.File;
import java.util.Scanner;

public class java_41243_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory:");
        String directoryPath = scanner.nextLine();

        scanDirectory(new File(directoryPath));
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    System.out.println(file.getPath());
                }
            }
        }
    }
}