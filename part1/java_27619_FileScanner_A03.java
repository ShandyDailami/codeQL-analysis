import java.io.File;
import java.util.Scanner;

public class java_27619_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        printFiles(directory, 0);
    }

    private static void printFiles(File file, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                printFiles(f, level + 1);
            }
        }
    }
}