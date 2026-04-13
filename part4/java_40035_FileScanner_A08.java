import java.io.File;
import java.util.Scanner;

public class java_40035_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] txtFiles = dir.listFiles((dir2, name) -> name.endsWith(".txt"));
            if (txtFiles != null) {
                for (File file : txtFiles) {
                    if (file.canRead()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File path: " + file.getAbsolutePath());
                        System.out.println();
                    } else {
                        System.out.println("Unable to read file: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }

        scanner.close();
    }
}