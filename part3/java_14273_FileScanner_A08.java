import java.io.File;
import java.util.Scanner;

public class java_14273_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println("Reading file: " + txtFile.getName());
                    Scanner fileScanner = new Scanner(txtFile);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                   
                    }
                    fileScanner.close();
                }
            } else {
                System.out.println("No .txt files in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }
}