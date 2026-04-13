import java.io.File;
import java.util.Scanner;

public class java_23114_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);

        printFiles(directory);
    }

    private static void printFiles(File directory) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                printFiles(file);
            }
        } else {
            System.out.println(directory.getAbsolutePath());
        }
    }
}