import java.io.File;
import java.util.Scanner;

public class java_28616_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Listing files with .txt extension in " + dirPath);

            File[] txtFiles = dir.listFiles((dir2, name) -> name.toLowerCase().endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println(txtFile.getName());
                }
            } else {
                System.out.println("No .txt files found in " + dirPath);
            }
        } else {
            System.out.println(dirPath + " is not a valid directory.");
        }
    }
}