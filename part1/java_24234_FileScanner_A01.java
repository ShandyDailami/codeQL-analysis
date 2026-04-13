import java.io.File;
import java.util.Scanner;

public class java_24234_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File file = new File(directoryPath);
        printFiles(file, 0);
    }

    private static void printFiles(File file, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFiles(f, depth + 1);
                }
            }
        }
    }
}