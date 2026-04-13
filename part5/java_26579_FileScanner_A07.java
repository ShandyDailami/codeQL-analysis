import java.io.File;
import java.util.Scanner;

public class java_26579_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        printFiles(directory);
    }

    private static void printFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFiles(file);
                }
            }
        }
    }
}