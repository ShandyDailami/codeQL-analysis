import java.io.File;
import java.util.Scanner;

public class java_37353_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        printFiles(new File(dirPath), ".txt");
    }

    private static void printFiles(File dir, String ext) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().endsWith(ext)) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFiles(file, ext);
                }
            }
        }
    }
}