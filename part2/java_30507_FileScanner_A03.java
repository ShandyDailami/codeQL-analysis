import java.io.File;
import java.util.Scanner;

public class java_30507_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] textFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));
        if (textFiles == null) {
            System.out.println("No text files found in the directory!");
            return;
        }

        for (File file : textFiles) {
            System.out.println("Found text file: " + file.getAbsolutePath());
        }
    }
}