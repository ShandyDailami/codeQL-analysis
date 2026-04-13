import java.io.File;
import java.util.Scanner;

public class java_15411_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));
            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    if (txtFile.canRead()) {
                        System.out.println("Found text file: " + txtFile.getAbsolutePath());
                    } else {
                        System.out.println("Unable to read text file: " + txtFile.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No text files found in directory: " + dirPath);
            }
        } else {
            System.out.println("Invalid directory path: " + dirPath);
        }

        scanner.close();
    }
}