import java.io.File;
import java.util.Scanner;

public class java_02319_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        String filePath = dirPath + "/" + fileName;
        File file = new File(filePath);

        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    if (line.contains("security-sensitive operation")) {
                        System.out.println("Found a line with security-sensitive operation");
                    }
                }
            }
        } else {
            System.out.println("File not found");
        }
    }
}