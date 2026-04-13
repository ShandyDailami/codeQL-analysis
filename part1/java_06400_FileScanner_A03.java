import java.io.File;
import java.util.Scanner;

public class java_06400_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        File rootDirectory = new File(directoryPath);
        scanFile(rootDirectory);
        scanner.close();
    }

    private static void scanFile(File file) {
        if (file.isDirectory()) {
            File[] directoryFiles = file.listFiles();
            if (directoryFiles != null) {
                for (File f : directoryFiles) {
                    scanFile(f);
                }
            }
        } else if (file.getName().endsWith(".txt")) {
            System.out.println("Found text file: " + file.getAbsolutePath());
        }
    }
}