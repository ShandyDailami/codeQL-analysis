import java.io.File;
import java.util.Scanner;

public class java_41203_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.getName().endsWith(".txt")) {
                            try {
                                Scanner fileScanner = new Scanner(f);
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    // This is a placeholder for security-sensitive operation
                                    // You should replace it with actual security-sensitive operation
                                    processLine(line);
                                }
                                fileScanner.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                System.out.println("Invalid file path");
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }

    private static void processLine(String line) {
        // This method is a placeholder for security-sensitive operation
        // You should replace it with actual security-sensitive operation
        // For example, you might remove all characters that are not alphanumeric or space,
        // or hash all the lines, or hash the whole file content.
        line = line.replaceAll("[^a-zA-Z0-9 ]", "");
        System.out.println(line);
    }
}