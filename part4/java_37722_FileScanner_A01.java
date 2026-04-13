import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37722_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        printFiles(new File(dirPath));
    }

    private static void printFiles(File dir) throws FileNotFoundException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    printFiles(file);
                }
            }
        }
    }
}