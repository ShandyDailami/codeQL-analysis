import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07225_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists()) {
            printFiles(file);
        } else {
            System.out.println("The provided path does not exist.");
        }
    }

    private static void printFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getAbsolutePath());
                } else {
                    printFiles(f);
                }
            }
        }
    }
}