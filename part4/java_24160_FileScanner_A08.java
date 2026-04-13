import java.io.File;
import java.util.Scanner;

public class java_24160_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        searchForTxtFiles(dir);
    }

    private static void searchForTxtFiles(File dir) {
        File[] files = dir.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("Found .txt file: " + file.getAbsolutePath());
                } else {
                    System.out.println("Found subdirectory: " + file.getAbsolutePath());
                    searchForTxtFiles(file);
                }
            }
        }
    }
}