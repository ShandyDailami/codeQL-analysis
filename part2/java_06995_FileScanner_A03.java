import java.io.File;
import java.util.Scanner;

public class java_06995_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        findFiles(new File(path));
    }

    private static void findFiles(File file) {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    findFiles(subFile);
                }
            }
        } else if (file.getName().endsWith(".txt")) {
            System.out.println("File found: " + file.getAbsolutePath());
        }
    }
}