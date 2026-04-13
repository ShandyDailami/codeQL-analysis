import java.io.File;
import java.util.Scanner;

public class java_11293_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the keyword:");
        String keyword = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            for (File txtFile : txtFiles) {
                if (readFile(txtFile, keyword)) {
                    System.out.println("File contains keyword: " + keyword);
                } else {
                    System.out.println("File does not contain keyword: " + keyword);
                }
            }
        } else {
            System.out.println("Invalid directory path or directory does not exist!");
        }

        scanner.close();
    }

    private static boolean readFile(File file, String keyword) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(keyword)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
            return false;
        }
        return false;
    }
}