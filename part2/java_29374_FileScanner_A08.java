import java.io.File;
import java.util.Scanner;

public class java_29374_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory";
        File dir = new File(dirPath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        int totalLines = 0;

        for (File file : dir.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    totalLines += scanner.nextLine().length();
                }
                scanner.close();
            }
        }

        System.out.println("Total line count: " + totalLines);
    }
}