import java.io.File;
import java.util.Scanner;

public class java_42108_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    if (txtFile.canRead()) {
                        System.out.println("File found: " + txtFile.getPath());
                    } else {
                        System.out.println("Error: Cannot read file " + txtFile.getPath());
                    }
                }
            } else {
                System.out.println("Error: No .txt files in directory " + dirPath);
            }
        } else {
            System.out.println("Error: Directory " + dirPath + " does not exist");
        }

        scanner.close();
    }
}