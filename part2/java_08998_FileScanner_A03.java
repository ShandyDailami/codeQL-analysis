import java.io.File;
import java.util.Scanner;

public class java_08998_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Enter file extension:");
            String extension = scanner.nextLine();

            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    if (file.isFile()) {
                        System.out.println("Found file: " + file.getName());
                    }
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}