import java.io.File;
import java.util.Scanner;

public class java_01610_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        printFiles(new File(directoryPath));
    }

    private static void printFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getPath());
                } else if (file.isDirectory()) {
                    printFiles(file);
                }
            }
        }
    }
}