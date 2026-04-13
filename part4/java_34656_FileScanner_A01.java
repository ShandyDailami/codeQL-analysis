import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34656_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        printFilesInDir(new File(dirPath));
    }

    private static void printFilesInDir(File dir) {
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                printFilesInDir(file);
            }
        } else {
            System.out.println(dir.getAbsolutePath());
        }
    }
}