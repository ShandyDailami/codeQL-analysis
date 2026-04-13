import java.io.File;
import java.util.Scanner;

public class java_05480_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);

        if (directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    if (txtFile.canRead()) {
                        System.out.println(txtFile.getName());
                    } else {
                        System.out.println("Unable to read file: " + txtFile.getName());
                    }
                }
            } else {
                System.out.println("No .txt files in directory.");
            }
        } else {
            System.out.println("Not a valid directory.");
        }
    }
}