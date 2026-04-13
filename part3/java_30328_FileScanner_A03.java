import java.io.File;
import java.util.Scanner;

public class java_30328_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        try {
            File dir = new File(dirPath);

            if (dir.exists() && dir.isDirectory()) {
                String[] files = dir.list();
                for (String fileName : files) {
                    File file = new File(dirPath + "/" + fileName);
                    if (file.canRead()) {
                        System.out.println("Reading file: " + fileName);
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                       
                            // This is a security-sensitive operation related to A03_Injection.
                            // In real scenarios, the operation can be more complex and requires user input.
                            // For the sake of simplicity, we'll just print the line for demonstration purposes.
                            System.out.println("Security-sensitive operation: " + line);
                        }
                        fileScanner.close();
                    }
                }
            } else {
                System.out.println("The provided path does not exist or is not a directory.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}