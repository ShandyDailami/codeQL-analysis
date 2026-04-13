import java.io.File;
import java.util.Scanner;

public class java_01390_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] secureFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (secureFiles != null) {
            for (File file : secureFiles) {
                if (file.canRead()) {
                    System.out.println("Reading file: " + file.getAbsolutePath());
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println("Line: " + line);
                    }
                    fileScanner.close();
                } else {
                    System.out.println("File cannot be read: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Directory does not exist or does not have read permissions: " + directoryPath);
        }

        scanner.close();
    }
}