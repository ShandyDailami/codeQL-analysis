import java.io.File;
import java.util.Scanner;

public class java_01939_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        File directory = new File(path);

        printFiles(directory);
    }

    private static void printFiles(File directory) {
        if (directory.listFiles() == null) {
            return;
        }

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else {
                printFiles(file);
            }
        }
    }
}