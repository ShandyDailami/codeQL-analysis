import java.io.File;
import java.util.Scanner;

public class java_04783_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        scanner.close();

        listFiles(new File(directoryPath));
    }

    private static void listFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getPath());
                } else if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }
}