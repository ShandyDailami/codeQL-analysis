import java.io.File;
import java.util.Scanner;

public class java_19474_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    readFile(file);
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getAbsolutePath());
        }
    }
}